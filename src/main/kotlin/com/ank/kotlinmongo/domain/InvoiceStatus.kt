package com.ank.kotlinmongo.domain

enum class InvoiceStatus(val tracked: Boolean) {
    APPROVED(true),
    CALCULATED_ERROR(false),
    CALCULATED_OK(false),
    CALCULATING(false),
    CLOSED(true),
    EXPORTED(true),
    INVOICED_ERROR(true),
    INVOICED_OK(true),
    INVOICING(false),
    PARTIAL_RESET(false),
    PENDING(false),
    REJECTED(true),
}
