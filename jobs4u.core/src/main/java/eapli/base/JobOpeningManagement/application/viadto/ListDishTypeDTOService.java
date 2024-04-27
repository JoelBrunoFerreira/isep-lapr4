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

import eapli.ecafeteria.dishmanagement.domain.DishType;
import eapli.ecafeteria.dishmanagement.dto.DishTypeDTO;
import eapli.ecafeteria.dishmanagement.repositories.DishTypeRepository;
import eapli.ecafeteria.infrastructure.persistence.PersistenceContext;
import eapli.ecafeteria.usermanagement.domain.CafeteriaRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * an application service to avoid code duplication.
 *
 * since this service works with DTOs it must transform from DTOs to domain
 * objects and vice versa whenever interfacing the presentation and domain
 * layers.
 *
 * @author Paulo Gandra de Sousa
 */
@ApplicationService
class ListDishTypeDTOService {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final DishTypeRepository dishTypeRepository = PersistenceContext.repositories()
            .dishTypes();

    public Iterable<DishTypeDTO> allDishTypes() {
        authz.ensureAuthenticatedUserHasAnyOf(CafeteriaRoles.POWER_USER,
                CafeteriaRoles.MENU_MANAGER);

        final Iterable<DishType> types = this.dishTypeRepository.findAll();
        return transformToDTO(types);
    }

    /**
     * Transform for the presentation layer.
     * <p>
     * The current implementation uses Java 8 streams. They are equivalent to more traditional java
     * code:
     *
     * <pre>
     * final List&lt;DishTypeDTO&gt; ret = new ArrayList&lt;&gt;();
     * Iterator&lt;dishType&gt; iter = types.iterator();
     * while (iter.hasNext()) {
     *      ret.add(t.toDTO()));
     * }
     * return ret;
     * </pre>
     *
     * Which was replaced by the for-each loop:
     *
     * <pre>
     * final List&lt;DishTypeDTO&gt; ret = new ArrayList&lt;&gt;();
     * for(DishType t: types) {
     *      ret.add(t.toDTO()));
     * }
     * return ret;
     * </pre>
     *
     * Which by the way could be simplified:
     *
     * <pre>
     * final List&lt;DishTypeDTO&gt; ret = new ArrayList&lt;&gt;();
     * types.forEach(e -> ret.add(e.toDTO()));
     * return ret;
     * </pre>
     *
     * @param types
     * @return
     */
    private Iterable<DishTypeDTO> transformToDTO(final Iterable<DishType> types) {
        return StreamSupport.stream(types.spliterator(), true)
                .map(DishType::toDTO)
                .collect(Collectors.toUnmodifiableList());
    }

    public Iterable<DishTypeDTO> activeDishTypes() {
        authz.ensureAuthenticatedUserHasAnyOf(CafeteriaRoles.POWER_USER,
                CafeteriaRoles.MENU_MANAGER);

        return transformToDTO(this.dishTypeRepository.activeDishTypes());
    }
}
