package com.eazybytes.loans.audit;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@ComponentScan("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {
    /**
     * Returns the current auditor of the application.
     *
     * @return the current auditor.
     */
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("LOANS_MS");
    }
}
