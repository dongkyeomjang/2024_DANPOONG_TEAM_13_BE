package com.daon.onjung.event.domain.mysql;

import com.daon.onjung.account.domain.Store;
import com.daon.onjung.account.domain.type.EBankName;
import com.daon.onjung.event.domain.type.EStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "events")
public class Event {
    /* -------------------------------------------- */
    /* Default Column ----------------------------- */
    /* -------------------------------------------- */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* -------------------------------------------- */
    /* Information Column ------------------------- */
    /* -------------------------------------------- */
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EStatus status;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "store_delivery_date", nullable = true)
    private LocalDate storeDeliveryDate;

    @Column(name = "ticket_issue_date", nullable = true)
    private LocalDate ticketIssueDate;

    @Column(name = "report_date", nullable = true)
    private LocalDate reportDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "bank_name")
    private EBankName bankName;

    @Column(name = "bank_id")
    private Long bankId;

    /* -------------------------------------------- */
    /* Many To One Mapping ------------------------ */
    /* -------------------------------------------- */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stores_id", nullable = false)
    private Store store;

    /* -------------------------------------------- */
    /* Methods ------------------------------------ */
    /* -------------------------------------------- */
    @Builder
    public Event(LocalDate startDate, LocalDate endDate, Store store) {
        this.status = EStatus.IN_PROGRESS;
        this.startDate = startDate;
        this.endDate = endDate;
        this.store = store;
    }

    public void updateBankInfo(EBankName bankName, Long bankId) {
        this.bankName = bankName;
        this.bankId = bankId;
    }

    public void completeEvent() {
        this.status = EStatus.TICKET_ISSUE;
        this.storeDeliveryDate = LocalDate.now();
        this.ticketIssueDate = LocalDate.now();
    }
}
