package org.sample.service

import org.sample.controller.SampleController
import org.sample.entity.SampleEntity
import org.sample.repository.SampleRepository
import org.sample.service.SampleService
import spock.lang.Specification

class SampleServiceTest extends Specification {

    SampleService sampleService
    SampleRepository sampleRepository

    def setup() {
        sampleRepository = Mock()
        sampleService = new SampleService(sampleRepository: sampleRepository)
    }

    def "validate getSample with data"() {
        given:
        def title = "world"
        SampleEntity sampleEntity = new SampleEntity(id: 5, title:'sampleA', rate: 2.45)
        1 * sampleRepository.getByTitle(title) >> Optional.of(sampleEntity)

        when:
        SampleEntity sampleEntityResponse = sampleService.getSample(title)

        then:
        sampleEntityResponse.rate == sampleEntity.rate

    }

    def "validate getSample without data"() {
        given:
        def title = "anyTitle"
        1 * sampleRepository.getByTitle(title) >> Optional.ofNullable()

        when:
        SampleEntity sampleEntityResponse = sampleService.getSample(title)

        then:
        sampleEntityResponse == null

    }

}