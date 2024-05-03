package com.gbook.gbookbackend.global.util.openfeign.client

import com.gbook.gbookbackend.global.util.openfeign.client.dto.GetBookListResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "BookFeign", url = "http://www.aladin.co.kr/ttb/api")
interface BookFeign {
    @GetMapping("/ItemSearch.aspx")
    fun searchBookList(
            @RequestParam("Query") query: String
    ): GetBookListResponse

    @GetMapping("/ItemList.aspx")
    fun getBestSellerList(
            @RequestParam("QueryType") queryType: String
    ): GetBookListResponse

}