package com.example.propertymanagment.service.impl;

import com.example.propertymanagment.converter.PropertyConverter;
import com.example.propertymanagment.dto.PropertyDTO;
import com.example.propertymanagment.entity.PropertyEntity;
import com.example.propertymanagment.repository.PropertyRepository;
import com.example.propertymanagment.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyConverter propertyConverter;
    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

        PropertyEntity pe = propertyConverter.convertDTOtoEntity(propertyDTO);
        pe = propertyRepository.save(pe);
        propertyDTO  = propertyConverter.converterEntityToDTO(pe);
        return propertyDTO;
    }

}
