/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.base.JobOpeningManagement.application;

import eapli.ecafeteria.dishmanagement.domain.*;
import eapli.ecafeteria.dishmanagement.repositories.AllergenRepository;
import eapli.ecafeteria.dishmanagement.repositories.DishRepository;
import eapli.ecafeteria.dishmanagement.repositories.DishTypeRepository;
import eapli.ecafeteria.usermanagement.domain.CafeteriaRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.money.domain.model.Money;

import java.util.Set;

/**
 * The controller for the use case "register new dish" using the domain objects.
 *
 * @see eapli.ecafeteria.dishmanagement.application.viadto.RegisterDishViaDTOController
 *
 * @author Jorge Santos ajs@isep.ipp.pt
 */
@UseCaseController
public class RegisterJobOpeningController {

    private final AuthorizationService authz;
    private final DishRepository dishRepository;

    private final ListDishTypeService svcDishTypes;
    private final ListAllergenService svcAllergens;

    public RegisterJobOpeningController(final AuthorizationService authz, final DishRepository dishRepository,
                                        final DishTypeRepository dishTypeRepo, final AllergenRepository allergenRepo) {
        // dependency injection - to make this object more testable we don't create the
        // infrastructure objects to avoid coupling to the implementation. This way, the controller
        // can be used in different scenarios with different implementations of the repository. for
        // instance, unit testing.
        this.authz = authz;
        this.dishRepository = dishRepository;

        // dependency injection - only the external plugable dependencies are injected. it makes no
        // sense to inject the ListDish and ListAllergen services as those are not supposed to be
        // plugable/replaceable.
        svcDishTypes = new ListDishTypeService(authz, dishTypeRepo);
        svcAllergens = new ListAllergenService(authz, allergenRepo);
    }

    public Dish registerDish(final DishType dishType, final String name, final Integer calories, final Integer salt,
            final double price) {
        return registerDish(dishType, name, calories, salt, price, null);
    }

    public Dish registerDish(final DishType dishType, final String name, final Integer calories, final Integer salt,
            final double price, final Set<Allergen> allergens) {

        authz.ensureAuthenticatedUserHasAnyOf(CafeteriaRoles.POWER_USER, CafeteriaRoles.MENU_MANAGER);

        final var newDish = new DishBuilder().ofType(dishType).named(Designation.valueOf(name))
                .costing(Money.euros(price)).withNutricionalInfo(new NutricionalInfo(calories, salt))
                .withAllergens(allergens).build();

        return dishRepository.save(newDish);
    }

    public Iterable<Allergen> allAllergens() {
        return svcAllergens.allAllergens();
    }

    public Iterable<DishType> dishTypes() {
        return svcDishTypes.activeDishTypes();
    }
}
