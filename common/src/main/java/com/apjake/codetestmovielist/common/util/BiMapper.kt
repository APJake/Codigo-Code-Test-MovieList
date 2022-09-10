package com.apjake.codetestmovielist.common.util

interface BiMapper<FROM, TO> {
    fun map(data: FROM): TO
    fun mapReverse(data: TO): FROM
}