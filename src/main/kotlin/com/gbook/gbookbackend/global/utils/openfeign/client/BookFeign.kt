package com.gbook.gbookbackend.global.utils.openfeign.client

import com.gbook.gbookbackend.global.utils.openfeign.client.dto.GetAladinBookListResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "BookFeign", url = "http://www.aladin.co.kr/ttb/api")
interface BookFeign {
    @GetMapping("/ItemSearch.aspx", consumes = ["application/json"])
    fun searchBookList(
        @RequestParam("Query") query: String,
        @RequestParam("start") start: Int,
        @RequestParam("Version") version: Int,
    ): GetAladinBookListResponse

    @GetMapping("/ItemList.aspx")
    fun getBestSellerList(
        @RequestParam("QueryType") queryType: String,
        @RequestParam("start") start: Int,
        @RequestParam("Version") version: Int,
        @RequestParam("SearchTarget") searchTarget: String,
    ): GetAladinBookListResponse

    @GetMapping("ItemLookUp.aspx")
    fun searchBookDetail(
        @RequestParam("Version") version: Int,
        @RequestParam("itemIdType") itemIdType: String,
        @RequestParam("ItemId") itemId: String
    ): GetAladinBookListResponse
}