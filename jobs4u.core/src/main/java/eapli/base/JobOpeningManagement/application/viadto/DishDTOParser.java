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
import eapli.ecafeteria.dishmanagement.domain.DishBuilder;
import eapli.ecafeteria.dishmanagement.domain.DishType;
import eapli.ecafeteria.dishmanagement.domain.NutricionalInfo;
import eapli.ecafeteria.dishmanagement.dto.DishDTO;
import eapli.ecafeteria.dishmanagement.repositories.DishTypeRepository;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.money.domain.model.Money;
import eapli.framework.representations.dto.DTOParser;

/**
 * @author Paulo Gandra de Sousa 2021/04/28
 */
class DishDTOParser implements DTOParser<DishDTO, Dish> {

    private final DishTypeRepository dishTypeRepository;

    /**
     * Configure the parser by injecting the necessary dependency.
     *
     * @param dishTypeRepository
     *            the dish type repository
     */
    public DishDTOParser(final DishTypeRepository dishTypeRepository) {
        this.dishTypeRepository = dishTypeRepository;
    }

    @Override
    public Dish valueOf(final DishDTO dto) {
        // retrieve the dish type
        final DishType type = dishTypeRepository.ofIdentity(dto.getDishTypeAcronym())
                .orElseThrow(() -> new IllegalArgumentException("Unknown dish type: " + dto.getDishTypeAcronym()));

        return new DishBuilder().ofType(type).named(Designation.valueOf(dto.getName()))
                .costing(Money.valueOf(dto.getPrice(), dto.getCurrency()))
                .withNutricionalInfo(new NutricionalInfo(dto.getCalories(), dto.getSalt())).build();
    }
}
