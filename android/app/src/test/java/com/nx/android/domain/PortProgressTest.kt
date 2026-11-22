package com.nx.android.domain

import com.nx.android.domain.porting.PortProgress
import org.junit.Assert.assertEquals
import org.junit.Test

class PortProgressTest {
    @Test
    fun `the bar follows the stages and the current stage's own fraction`() {
        assertEquals(0f, PortProgress.overall(0, 9, 0f), 0f)
        assertEquals(0f, PortProgress.overall(1, 9, 0f), 0f)
        assertEquals(0.5f / 9, PortProgress.overall(1, 9, 0.5f), 1e-6f)
        assertEquals(6f / 9, PortProgress.overall(7, 9, 0f), 1e-6f)
        assertEquals(8f / 9, PortProgress.overall(9, 9, 0f), 1e-6f)
        assertEquals(1f, PortProgress.overall(9, 9, 1f), 0f)
    }

    @Test
    fun `an unknown plan or a fraction out of range stays within 0 to 1`() {
        assertEquals(0f, PortProgress.overall(3, 0, 0.4f), 0f)
        assertEquals(1f, PortProgress.overall(3, 3, 2f), 0f)
    }
}