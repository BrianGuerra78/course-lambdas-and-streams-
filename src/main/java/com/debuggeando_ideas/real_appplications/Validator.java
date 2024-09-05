package com.debuggeando_ideas.real_appplications;

import java.util.List;

@FunctionalInterface
public interface Validator <t, e extends Exception> {
    void validate(t target) throws e;

    static <t, e extends Exception> void applyRules(List<Validator<t,e>> rules, t target) throws e {
        for (Validator<t, e> rule : rules) {
            rule.validate(target);
        }
    }

}
