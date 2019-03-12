package com.kotlin.githubapi.data.user.parameter

import com.kotlin.githubapi.data.base.BasePagingParameters

class SearchUserParameters(page: Int? = null, per_page: Int? = null, val q: String)
    : BasePagingParameters(page, per_page)