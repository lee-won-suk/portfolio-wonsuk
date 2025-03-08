package com.wonsuk.portfolio.domain.entity

import jakarta.persistence.*
import jakarta.servlet.http.HttpServletRequest

@Entity
class HttpInterface(httpServletRequest: HttpServletRequest) : BaseEnitity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "http_interface_id") // id를 안쓰는 이유는 achive2개뭍이는게 별로라서
    var id: Long? = null

    var cookies: String? = httpServletRequest.cookies
        ?.joinToString(separator = "") { "${it.name}:${it.value}:" }
    var referer: String? = httpServletRequest.getHeader("referer")
    var localAddr: String? = httpServletRequest.localAddr
    var remoteAddor: String? = httpServletRequest.remoteAddr
    var remoteHost: String? = httpServletRequest.remoteHost
    var requestUri: String? = httpServletRequest.requestURI
    var userAgent: String? = httpServletRequest.getHeader("user-agent")


}
