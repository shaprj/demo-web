/*
    Created by O.Shalaevsky on 28.02.2020
*/

package com.shaprj.spring.demoweb.model.admin.converter.user;

import javax.persistence.AttributeConverter;

public class IsMaleConverter implements AttributeConverter<Boolean, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Boolean aBoolean) {
        return aBoolean ? 1 : 0;
    }

    @Override
    public Boolean convertToEntityAttribute(Integer integer) {
        return integer == 1 ? true : false;
    }
}
