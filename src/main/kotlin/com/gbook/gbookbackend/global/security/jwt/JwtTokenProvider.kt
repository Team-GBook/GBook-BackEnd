package com.gbook.gbookbackend.global.security.jwt

import antlr.Token
import com.gbook.gbookbackend.domain.user.domain.RefreshToken
import com.gbook.gbookbackend.domain.user.domain.repository.RefreshTokenRepository
import com.gbook.gbookbackend.domain.user.presentation.dto.response.TokenResponse
import com.gbook.gbookbackend.global.exception.TokenExpiredException
import com.gbook.gbookbackend.global.exception.TokenInvalidException
import com.gbook.gbookbackend.global.security.auth.AuthDetailsService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import org.springframework.stereotype.Component
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.util.StringUtils
import java.util.*
import javax.servlet.http.HttpServletRequest

@Component
class JwtTokenProvider(
    private val jwtProperties: JwtProperties,
    private val authDetailsService: AuthDetailsService,
    private val refreshTokenRepository: RefreshTokenRepository
) {
    fun getToken(email: String): TokenResponse {
        val accessToken: String = generateAccessToken(email)
        val refreshToken: String = generateRefreshToken(email)

        return TokenResponse(
            accessToken = accessToken,
            refreshToken = refreshToken
        )
    }
    fun generateAccessToken(email: String): String {
        return createToken(email, "Access", jwtProperties.accessExp)
    }

    fun generateRefreshToken(email: String): String {
        val refreshToken = createToken(email, "Refresh", jwtProperties.refreshExp)

        refreshTokenRepository.save(
            RefreshToken(
                email = email,
                token = refreshToken
            )
        )
        return refreshToken
    }

    fun createToken(email: String, type: String, expired: Long): String {
        return Jwts.builder()
                .setSubject(email)
                .claim("type", type)
                .signWith(SignatureAlgorithm.HS256, jwtProperties.secret)
                .setExpiration(Date(System.currentTimeMillis() + expired * 1000))
                .setIssuedAt(Date())
                .compact()
    }

    fun getAuthentication(token: String): UsernamePasswordAuthenticationToken {
        val userDetails: UserDetails = authDetailsService.loadUserByUsername(getAccountId(token))
        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }

    private fun getAccountId(token: String): String {
        return getClaims(token).subject
    }

    private fun getClaims(token: String): Claims {
        return try {
            Jwts.parser()
                    .setSigningKey(jwtProperties.secret)
                    .parseClaimsJws(token)
                    .body
        } catch (e: ExpiredJwtException) {
            throw TokenExpiredException.EXCPETION
        } catch (e: Exception) {
            e.printStackTrace()
            throw TokenInvalidException.EXCPETION
        }
    }

    fun resolveToken(request: HttpServletRequest): String? {
        val bearerToken = request.getHeader("Authorization")

        return if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")) {
            bearerToken.replace("Bearer", "")
        } else null
    }
}