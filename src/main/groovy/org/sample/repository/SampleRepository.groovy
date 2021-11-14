package org.sample.repository

import org.sample.entity.SampleEntity
import org.springframework.data.repository.PagingAndSortingRepository

interface SampleRepository extends PagingAndSortingRepository<SampleEntity, Integer> {

    Optional<SampleEntity> getByTitle(String title)

}
