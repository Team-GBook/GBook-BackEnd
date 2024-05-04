package com.gbook.gbookbackend.global.util.openfeign

import com.gbook.gbookbackend.global.exception.InternalServerError
import com.gbook.gbookbackend.global.util.openfeign.client.exception.FeignBadRequestException
import com.gbook.gbookbackend.global.util.openfeign.client.exception.FeignForbiddenException
import com.gbook.gbookbackend.global.util.openfeign.client.exception.FeignTokenExpiredException
import com.gbook.gbookbackend.global.util.openfeign.client.exception.FeignUnAuthorizedException
import feign.FeignException
import feign.Response
import feign.codec.ErrorDecoder

class FeignClientErrorDecoder : ErrorDecoder {
    override fun decode(methodKey: String, response: Response): Exception {
        if (response.status() >= 400) {
            when (response.status()) {
                400 -> throw FeignBadRequestException
                401 -> throw FeignUnAuthorizedException
                403 -> throw FeignForbiddenException
                419 -> throw FeignTokenExpiredException
                else -> throw InternalServerError
            }
        }

        return FeignException.errorStatus(methodKey, response)
    }
}