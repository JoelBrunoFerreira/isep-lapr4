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
import eapli.framework.money.domain.model.Money;
import eapli.framework.representations.RepresentationBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The builder for a DishDTO using the RepresentationBuilder interface. This
 * builder is forgiving in the sense that it ignores properties that it doesn't
 * understand in case the Dish has evolved to support new properties.
 *
 * @author Paulo Gandra de Sousa
 */
class DishDTORepresentationBuilder implements RepresentationBuilder<DishDTO> {

    private static final Logger LOGGER = LogManager.getLogger(DishDTORepresentationBuilder.class);

    private static final String PROPERTY_NOT_KNOW_IN_DISH_DTO = "Property '{}' not know in dishDTO";

    // an example of a builder that creates the "product" but hides that way from
    // the client code
    private DishDTO dto = new DishDTO();

    private String childObject = "";

    @Override
    public DishDTO build() {

        final DishDTO ret = dto;
        // ensure if someone reuses this builder won't change the already built object
        // but actually
        // work on a new object
        dto = new DishDTO();
        return ret;
    }

    @Override
    public RepresentationBuilder<DishDTO> startObject(final String name) {
        childObject = name;
        return this;
    }

    @Override
    public RepresentationBuilder<DishDTO> endObject() {
        childObject = "";
        return this;
    }

    @Override
    public RepresentationBuilder<DishDTO> withProperty(final String name, final String value) {
        if ("name".equals(name)) {
            dto.setName(value);
        } else if ("acronym".equals(name) && "dishType".equals(childObject)) {
            dto.setDishTypeAcronym(value);
        } else if ("description".equals(name) && "dishType".equals(childObject)) {
            dto.setDishTypeDescription(value);
        } else {
            LOGGER.warn(PROPERTY_NOT_KNOW_IN_DISH_DTO, name);
        }
        return this;
    }

    @Override
    public RepresentationBuilder<DishDTO> withProperty(final String name, final Integer value) {
        if ("salt".equals(name) && "nutricionalInfo".equals(childObject)) {
            dto.setSalt(value);
        } else if ("calories".equals(name) && "nutricionalInfo".equals(childObject)) {
            dto.setCalories(value);
        } else {
            LOGGER.warn(PROPERTY_NOT_KNOW_IN_DISH_DTO, name);
        }
        return this;
    }

    @Override
    public RepresentationBuilder<DishDTO> withProperty(final String name, final Money value) {
        if ("currentPrice".equals(name)) {
            dto.setPrice(value.amountAsDouble());
            dto.setCurrency(value.currency().toString());
        } else {
            LOGGER.warn(PROPERTY_NOT_KNOW_IN_DISH_DTO, name);
        }
        return this;
    }

    @Override
    public RepresentationBuilder<DishDTO> withProperty(final String name, final Boolean value) {
        if ("active".equals(name)) {
            dto.setActive(value);
        } else {
            LOGGER.warn(PROPERTY_NOT_KNOW_IN_DISH_DTO, name);
        }
        return this;
    }

    @Override
    public RepresentationBuilder<DishDTO> withElement(final String value) {
        LOGGER.warn("DishDTO has no collections; tried to create element {}", value);
        return this;
    }
}
