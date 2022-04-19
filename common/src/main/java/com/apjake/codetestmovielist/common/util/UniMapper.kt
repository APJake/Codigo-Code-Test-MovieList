package com.apjake.codetestmovielist.common.util

interface UniMapper<FROM, TO> {
    fun map(data: FROM): TO
}