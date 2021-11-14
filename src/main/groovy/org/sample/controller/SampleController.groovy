package org.sample.controller

import org.sample.entity.SampleEntity
import org.sample.service.SampleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleController {

    @Autowired
    SampleService sampleService

    @GetMapping("/sample")
    SampleEntity getSample(@RequestParam(name = "title") String title) {
        return sampleService.getSample(title)
    }

}
