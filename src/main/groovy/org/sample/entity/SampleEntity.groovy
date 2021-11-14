package org.sample.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "sample_table")
class SampleEntity {

    @Id
    Integer id

    @Column
    String title

    @Column
    BigDecimal rate

}
