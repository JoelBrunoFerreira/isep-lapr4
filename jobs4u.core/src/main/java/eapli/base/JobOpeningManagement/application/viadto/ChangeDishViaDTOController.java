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
package eapli.base.JobOpeningManagement.application.viadto;

import eapli.ecafeteria.dishmanagement.domain.Dish;
import eapli.ecafeteria.dishmanagement.domain.DishType;
import eapli.ecafeteria.dishmanagement.domain.NutricionalInfo;
import eapli.ecafeteria.dishmanagement.dto.ChangeDishNutricionalInfoDTO;
import eapli.ecafeteria.dishmanagement.dto.ChangeDishPriceDTO;
import eapli.ecafeteria.dishmanagement.dto.DishDTO;
import eapli.ecafeteria.dishmanagement.repositories.DishRepository;
import eapli.ecafeteria.dishmanagement.repositories.DishTypeRepository;
import eapli.ecafeteria.infrastructure.persistence.PersistenceContext;
import eapli.ecafeteria.usermanagement.domain.CafeteriaRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.money.domain.model.Money;

import java.util.Optional;

/**
 * A controller to showcase how to handle DTOs for "update" use cases.
 *
 * @author Paulo Gandra de Sousa 2021.05.03
 */
@UseCaseController
public class ChangeDishViaDTOController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final DishRepository dishRepository = PersistenceContext.repositories().dishes();
    private final DishTypeRepository dishTypeRepository = PersistenceContext.repositories().dishTypes();
    private final ListDishDTOService svc = new ListDishDTOService();

    /**
     * @return
     */
    public Iterable<DishDTO> allDishes() {
        return svc.allDishes();
    }

    /**
     * @param id
     *
     * @return
     */
    public Optional<DishDTO> searchDish(final String id) {
        return dishRepository.ofIdentity(Designation.valueOf(id)).map(Dish::toDTO);
    }

    /**
     * Updates all the data of the dish. This is a typical use case approach where
     * there is no notion of "user task" and everything is read/updated as in a data
     * grid. The input to this method is the Dish DTO since the UI is data grid/form
     * to show the whole dish and allow the user to update whatever she wants..
     *
     * @param dishDTO
     *
     * @return
     */
    public DishDTO updateDish(final DishDTO dishDTO) {
        authz.ensureAuthenticatedUserHasAnyOf(CafeteriaRoles.POWER_USER, CafeteriaRoles.MENU_MANAGER);
        if (dishDTO == null) {
            throw new IllegalArgumentException();
        }

        var dish = dishRepository.ofIdentity(Designation.valueOf(dishDTO.getName()))
                .orElseThrow(IllegalArgumentException::new);
        final DishType type = dishTypeRepository.ofIdentity(dishDTO.getDishTypeAcronym())
                .orElseThrow(IllegalArgumentException::new);

        dish.update(type, dishDTO.isActive(), Money.valueOf(dishDTO.getPrice(), dishDTO.getCurrency()),
                new NutricionalInfo(dishDTO.getCalories(), dishDTO.getSalt()));

        dish = dishRepository.save(dish);

        return dish.toDTO();
    }

    /**
     * This is an example of a "task based" approach where individual changes are
     * explicitly ordered by the user instead of following a data grid mentality.
     * The input to this method is a Tailored DTO that represents the actual intent
     * of the user (a "command").
     *
     * @param dish
     * @param newPrice
     *
     * @return
     */
    public DishDTO changeDishPrice(final ChangeDishPriceDTO request) {
        authz.ensureAuthenticatedUserHasAnyOf(CafeteriaRoles.POWER_USER, CafeteriaRoles.MENU_MANAGER);
        if (request == null) {
            throw new IllegalArgumentException();
        }

        final var dish = dishRepository.ofIdentity(Designation.valueOf(request.getName()))
                .orElseThrow(IllegalArgumentException::new);
        dish.changePriceTo(Money.valueOf(request.getPrice(), request.getCurrency()));

        return dishRepository.save(dish).toDTO();
    }

    /**
     * This is an example of a "task based" approach where individual changes are
     * explicitly ordered by the user instead of following a data grid mentality.
     * The input to this method is a Tailored DTO that represents the actual intent
     * of the user (a "command").
     *
     * @param dish
     * @param newNutricionalInfo
     *
     * @return
     */
    public DishDTO changeDishNutricionalInfo(final ChangeDishNutricionalInfoDTO request) {
        authz.ensureAuthenticatedUserHasAnyOf(CafeteriaRoles.POWER_USER, CafeteriaRoles.MENU_MANAGER);
        if (request == null) {
            throw new IllegalArgumentException();
        }

        final var dish = dishRepository.ofIdentity(Designation.valueOf(request.getName()))
                .orElseThrow(IllegalArgumentException::new);
        dish.changeNutricionalInfoTo(new NutricionalInfo(request.getCalories(), request.getSalt()));

        return dishRepository.save(dish).toDTO();
    }
}
