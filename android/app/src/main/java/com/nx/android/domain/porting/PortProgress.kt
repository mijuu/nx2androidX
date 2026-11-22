package com.nx.android.domain.porting

/**
 * 构建自身的完成度：已结束的阶段 + 当前阶段自己的比例。移植器的 frac 只描述**当前阶段**（多数阶段没有
 * 计数，一直是 0），直接当总进度用，会长时间停在 0%、而这几个阶段恰恰最长；阶段结束时推进一格，条与
 * 卡片上的百分比才跟着构建走。
 */
object PortProgress {

    fun overall(stage: Int, stages: Int, stageFrac: Float): Float {
        if (stages <= 0) return 0f
        val finished = (stage - 1).coerceIn(0, stages)
        return ((finished + stageFrac.coerceIn(0f, 1f)) / stages).coerceIn(0f, 1f)
    }
}