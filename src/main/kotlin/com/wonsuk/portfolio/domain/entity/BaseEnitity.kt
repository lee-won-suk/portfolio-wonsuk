package com.wonsuk.portfolio.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@MappedSuperclass // 상속받는 클래스가 테이블에 매핑
abstract class BaseEnitity {

    @CreatedDate
    @Column(nullable = false, updatable = false) //null 금지, 처음세팅된 값 업데이트 금지
    var createdDateTime: LocalDateTime = LocalDateTime.now();

    @LastModifiedDate //마지막으로 수정된 일시
    @Column(nullable = false) //
    var updatedDateTime: LocalDateTime = LocalDateTime.now();

}
