package org.sample.service

import org.sample.entity.SampleEntity
import org.sample.repository.SampleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SampleService {

    @Autowired
    SampleRepository sampleRepository

    SampleEntity getSample(String title) {
        Optional<SampleEntity> optionalSampleEntity = sampleRepository.getByTitle(title)
        if (optionalSampleEntity.isPresent())
            return optionalSampleEntity.get()

        return null
    }

}
