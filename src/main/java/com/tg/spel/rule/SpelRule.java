package com.tg.spel.rule;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author wangyujie
 */
@Data
@AllArgsConstructor
public class SpelRule {
    private List<String> filterRuleList;
    private String service;
}
