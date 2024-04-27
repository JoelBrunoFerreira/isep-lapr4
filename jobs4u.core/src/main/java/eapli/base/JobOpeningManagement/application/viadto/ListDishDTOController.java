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

import eapli.ecafeteria.dishmanagement.dto.DishDTO;
import eapli.framework.application.UseCaseController;

/**
 * Since this controller works with DTOs it must transform from DTOs to domain
 * objects and vice versa whenever interfacing the presentation and domain
 * layers. Also, some some related domain object is needed it must first be
 * retrieved from the repository prior to its use.
 *
 *
 * <p>
 * <img src="list-dish-DTO-seq.svg">
 * </p>
 *
 * @see eapli.ecafeteria.dishmanagement.application.ListDishController
 *
 * @author Paulo Gandra de Sousa
 *
 *         <!--
 *
 * @startuml list-dish-DTO-seq.svg
 *
 *           Title Sequence Diagram for List Dish using DTO
 *
 *           ListDishViaDTOUI -> ListDishDTOController: create
 *           ListDishViaDTOUI -> ListDishDTOController: allDishes()
 *           activate ListDishDTOController
 *
 *           ListDishDTOController -> ListDishDTOService: allDishes()
 *           activate ListDishDTOService
 *
 *           ListDishDTOService -> DishRepository: findAll()
 *           activate DishRepository
 *
 *           ListDishDTOService <-- DishRepository: Iterable<Dish>
 *           deactivate DishRepository
 *
 *
 *           loop foreach Dish
 *           activate Dish
 *           ListDishDTOService -> Dish:toDTO()
 *           Dish -> DishDTO : create
 *           ListDishDTOService <-- Dish:DishDTO
 *           end
 *           deactivate Dish
 *
 *           ListDishDTOController <-- ListDishDTOService: Iterable<DishDTO>
 *           deactivate ListDishDTOService
 *
 *           ListDishViaDTOUI <-- ListDishDTOController: Iterable<DishDTO>
 *           deactivate ListDishDTOController
 * @enduml
 *         -->
 */
@UseCaseController
public class ListDishDTOController {

    private final ListDishDTOService svc = new ListDishDTOService();

    public Iterable<DishDTO> allDishes() {
        return svc.allDishes();
    }
}
