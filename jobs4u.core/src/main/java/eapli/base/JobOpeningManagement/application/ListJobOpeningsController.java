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

import eapli.ecafeteria.dishmanagement.domain.Dish;
import eapli.framework.application.UseCaseController;

/**
 *
 * <p>
 * <img src="list-dish-seq.svg">
 * </p>
 *
 * @see eapli.ecafeteria.dishmanagement.application.viadto.ListDishDTOController
 * @author Created on 29/03/2016.
 *
 *         <!--
 *
 * @startuml list-dish-seq.svg
 *
 *           Title Sequence Diagram for Dish List using Domain Objects
 *
 *           ListDishUI -> ListDishController: allDishes()
 *           activate ListDishController
 *
 *           ListDishController -> ListDishService: allDishes()
 *           activate ListDishService
 *
 *           ListDishService -> DishRepository: findAll()
 *           activate DishRepository
 *
 *           ListDishService <-- DishRepository: Iterable<Dish>
 *           deactivate DishRepository
 *
 *           ListDishController <-- ListDishService: Iterable<Dish>
 *           deactivate ListDishService
 *
 *           ListDishUI <-- ListDishController: Iterable<Dish>
 *           deactivate ListDishController
 *
 * @enduml
 *
 *         -->
 */
@UseCaseController
public class ListJobOpeningsController {

    private final ListDishService svc = new ListDishService();

    public Iterable<Dish> allDishes() {
        return svc.allDishes();
    }
}
