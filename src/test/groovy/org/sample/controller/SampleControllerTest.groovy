package org.sample.controller

import org.sample.entity.SampleEntity
import org.sample.service.SampleService
import spock.lang.Specification

class SampleControllerTest extends Specification {

    SampleService sampleService
    SampleController sampleController

    def setup() {
        sampleService = Mock()
        sampleController = new SampleController(sampleService: sampleService)
    }

    def "validate getSample with data"() {
        given:
        def title = "world"
        SampleEntity sampleEntity = new SampleEntity(id: 5, title:'sampleA', rate: 2.45)
        1 * sampleService.getSample(title) >> sampleEntity

        when:
        SampleEntity sampleEntityResponse = sampleController.getSample(title)

        then:
        sampleEntityResponse.rate == sampleEntity.rate

    }

    def "validate getSample without data"() {
        given:
        def title = "anyTitle"
        1 * sampleService.getSample(title) >> null

        when:
        SampleEntity sampleEntityResponse = sampleController.getSample(title)

        then:
        sampleEntityResponse == null

    }

}