package com.blackbaud.optimusprime.core.service;

import com.blackbaud.optimusprime.api.extension.ContactableEntityExtension;
import com.blackbaud.optimusprime.api.extension.Active;
import com.blackbaud.optimusprime.api.extension.DonorStatus;
import com.blackbaud.optimusprime.api.extension.EmailOptInStatus;
import com.blackbaud.optimusprime.api.extension.EmailStatus;
import com.blackbaud.optimusprime.api.extension.MembershipStatus;
import com.blackbaud.optimusprime.api.extension.SustainedStatus;
import com.blackbaud.optimusprime.api.extension.TransactionDonationType;
import com.blackbaud.optimusprime.api.extension.TransactionPaymentMethod;
import com.blackbaud.optimusprime.api.extension.TransactionTenderType;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ContactableEntityExtensionMessageCreator {

    public ContactableEntityExtension createMessageFromRecord(ConsumerRecord<String, GenericRecord> record, UUID contactId, UUID tenantId) {
        final Object siteId = record.value().get("SITE_ID");
        final Object consId = record.value().get("CONS_ID");
        final Object userName = record.value().get("USER_NAME");
        final Object originSrcCode = record.value().get("ORIGIN_SRC_CODE");
        final Object originSubsrcCode = record.value().get("ORIGIN_SUBSRC_CODE");
        final Object creationDate = record.value().get("CREATION_DATE");
        final Object createdBy = record.value().get("CREATED_BY");
        final Object modifyDate = record.value().get("MODIFY_DATE");
        final Object lastChangeBy = record.value().get("LAST_CHANGE_BY");
        final Object hardBounceCount = record.value().get("HARD_BOUNCE_COUNT");
        final Object softBounceCount = record.value().get("SOFT_BOUNCE_COUNT");
        final Object congDistId = record.value().get("CONG_DIST_ID");
        final Object congDistIdOverride = record.value().get("CONG_DIST_ID_OVERRIDE");
        final Object stateSenateDistId = record.value().get("STATE_SENATE_DIST_ID");
        final Object stateSenateDistIdOverride = record.value().get("STATE_SENATE_DIST_ID_OVERRIDE");
        final Object stateHouseDistId = record.value().get("STATE_HOUSE_DIST_ID");
        final Object stateHouseDistIdOverride = record.value().get("STATE_HOUSE_DIST_ID_OVERRIDE");
        final Object homeCountyOverride = record.value().get("HOME_COUNTY_OVERRIDE");
        final Object homeMunicipality = record.value().get("HOME_MUNICIPALITY");
        final Object homeMunicipalityOverride = record.value().get("HOME_MUNICIPALITY_OVERRIDE");
        final Object municipalId = record.value().get("MUNICIPAL_ID");
        final Object municipalIdOverride = record.value().get("MUNICIPAL_ID_OVERRIDE");
        final Object municipalDistId = record.value().get("MUNICIPAL_DIST_ID");
        final Object municipalDistIdOverride = record.value().get("MUNICIPAL_DIST_ID_OVERRIDE");
        final Object employer = record.value().get("EMPLOYER");
        final Object consOccupation = record.value().get("CONS_OCCUPATION");
        final Object firstTransDate = record.value().get("FIRST_TRANS_DATE");
        final Object firstTransAmount = record.value().get("FIRST_TRANS_AMOUNT");
        final Object firstTransCampaign = record.value().get("FIRST_TRANS_CAMPAIGN");
        final Object firstTransCampaignId = record.value().get("FIRST_TRANS_CAMPAIGN_ID");
        final Object lastTransDate = record.value().get("LAST_TRANS_DATE");
        final Object lastTransAmount = record.value().get("LAST_TRANS_AMOUNT");
        final Object lastTransCampaign = record.value().get("LAST_TRANS_CAMPAIGN");
        final Object lastTransCampaignId = record.value().get("LAST_TRANS_CAMPAIGN_ID");
        final Object largestTransDate = record.value().get("LARGEST_TRANS_DATE");
        final Object largestTransAmount = record.value().get("LARGEST_TRANS_AMOUNT");
        final Object largestTransCampaign = record.value().get("LARGEST_TRANS_CAMPAIGN");
        final Object largestTransCampaignId = record.value().get("LARGEST_TRANS_CAMPAIGN_ID");
        final Object prevYearTotalYear = record.value().get("PREV_YEAR_TOTAL_YEAR");
        final Object prevYearTotalTransAmount = record.value().get("PREV_YEAR_TOTAL_TRANS_AMOUNT");
        final Object currYearTotalTransAmount = record.value().get("CURR_YEAR_TOTAL_TRANS_AMOUNT");
        final Object lifetimeTotalTransAmount = record.value().get("LIFETIME_TOTAL_TRANS_AMOUNT");
        final Object externalFirstGiftDate = record.value().get("EXTERNAL_FIRST_GIFT_DATE");
        final Object externalFirstGiftAmount = record.value().get("EXTERNAL_FIRST_GIFT_AMOUNT");
        final Object externalLastGiftDate = record.value().get("EXTERNAL_LAST_GIFT_DATE");
        final Object externalLastGiftAmount = record.value().get("EXTERNAL_LAST_GIFT_AMOUNT");
        final Object externalLargestGiftDate = record.value().get("EXTERNAL_LARGEST_GIFT_DATE");
        final Object externalLargestGiftAmount = record.value().get("EXTERNAL_LARGEST_GIFT_AMOUNT");
        final Object externalYtdGiftAmount = record.value().get("EXTERNAL_YTD_GIFT_AMOUNT");
        final Object externalYtdGiftCount = record.value().get("EXTERNAL_YTD_GIFT_COUNT");
        final Object externalLifetimeGiftAmount = record.value().get("EXTERNAL_LIFETIME_GIFT_AMOUNT");
        final Object externalLifetimeGiftCount = record.value().get("EXTERNAL_LIFETIME_GIFT_COUNT");
        final Object prevYearAlertResponseCount = record.value().get("PREV_YEAR_ALERT_RESPONSE_COUNT");
        final Object currYearAlertResponseCount = record.value().get("CURR_YEAR_ALERT_RESPONSE_COUNT");
        final Object lifetimeAlertResponseCount = record.value().get("LIFETIME_ALERT_RESPONSE_COUNT");
        final Object memberSinceDate = record.value().get("MEMBER_SINCE_DATE");
        final Object membershipId = record.value().get("MEMBERSHIP_ID");
        final Object membershipLevelId = record.value().get("MEMBERSHIP_LEVEL_ID");
        final Object membershipExpirationDate = record.value().get("MEMBERSHIP_EXPIRATION_DATE");
        final Object sustainedMonthlyAmount = record.value().get("SUSTAINED_MONTHLY_AMOUNT");
        final Object sustainedStartDate = record.value().get("SUSTAINED_START_DATE");
        final Object sustainedPlannedEndDate = record.value().get("SUSTAINED_PLANNED_END_DATE");
        final Object active = record.value().get("ACTIVE");
        final Object donorStatus = record.value().get("DONOR_STATUS");
        final Object emailStatus = record.value().get("EMAIL_STATUS");
        final Object emailOptInStatus = record.value().get("EMAIL_OPT_IN_STATUS");
        final Object firstTransTenderType = record.value().get("FIRST_TRANS_TENDER_TYPE");
        final Object lastTransTenderType = record.value().get("LAST_TRANS_TENDER_TYPE");
        final Object largestTransTenderType = record.value().get("LARGEST_TRANS_TENDER_TYPE");
        final Object firstTransPayMethod = record.value().get("FIRST_TRANS_PAY_METHOD");
        final Object lastTransPayMethod = record.value().get("LAST_TRANS_PAY_METHOD");
        final Object largestTransPayMethod = record.value().get("LARGEST_TRANS_PAY_METHOD");
        final Object firstTransDonationType = record.value().get("FIRST_TRANS_DONATION_TYPE");
        final Object lastTransDonationType = record.value().get("LAST_TRANS_DONATION_TYPE");
        final Object largestTransDonationType = record.value().get("LARGEST_TRANS_DONATION_TYPE");
        final Object membershipStatus = record.value().get("MEMBERSHIP_STATUS");
        final Object sustainedStatus = record.value().get("SUSTAINED_STATUS");

        if (userName == null) {
            throw new RecoverableException("Tried to process record with null user_name");
        }

        return ContactableEntityExtension.builder()
                .id(contactId)
                .siteId(Integer.parseInt(siteId.toString()))
                .tenantId(tenantId)
                .consId(Long.parseLong(consId.toString()))
                .userName(userName.toString())
                .originSrcCode(getNullableString(originSrcCode))
                .originSubsrcCode(getNullableString(originSubsrcCode))
                .creationDate(getNullableLong(creationDate))
                .createdBy(getNullableLong(createdBy))
                .modifyDate(getNullableLong(modifyDate))
                .lastChangeBy(getNullableLong(lastChangeBy))
                .hardBounceCount(getNullableLong(hardBounceCount))
                .softBounceCount(getNullableLong(softBounceCount))
                .congDistId(getNullableString(congDistId))
                .congDistIdOverride(getNullableString(congDistIdOverride))
                .stateSenateDistId(getNullableString(stateSenateDistId))
                .stateSenateDistIdOverride(getNullableString(stateSenateDistIdOverride))
                .stateHouseDistId(getNullableString(stateHouseDistId))
                .stateHouseDistIdOverride(getNullableString(stateHouseDistIdOverride))
                .homeCountyOverride(getNullableString(homeCountyOverride))
                .homeMunicipality(getNullableString(homeMunicipality))
                .homeMunicipalityOverride(getNullableString(homeMunicipalityOverride))
                .municipalId(getNullableString(municipalId))
                .municipalIdOverride(getNullableString(municipalIdOverride))
                .municipalDistId(getNullableString(municipalDistId))
                .municipalDistIdOverride(getNullableString(municipalDistIdOverride))
                .employer(getNullableString(employer))
                .consOccupation(getNullableString(consOccupation))
                .firstTransDate(getNullableLong(firstTransDate))
                .firstTransAmount(getNullableLong(firstTransAmount))
                .firstTransCampaign(getNullableString(firstTransCampaign))
                .firstTransCampaignId(getNullableLong(firstTransCampaignId))
                .lastTransDate(getNullableLong(lastTransDate))
                .lastTransAmount(getNullableLong(lastTransAmount))
                .lastTransCampaign(getNullableString(lastTransCampaign))
                .lastTransCampaignId(getNullableLong(lastTransCampaignId))
                .largestTransDate(getNullableLong(largestTransDate))
                .largestTransAmount(getNullableLong(largestTransAmount))
                .largestTransCampaign(getNullableString(largestTransCampaign))
                .largestTransCampaignId(getNullableLong(largestTransCampaignId))
                .prevYearTotalYear(getNullableInt(prevYearTotalYear))
                .prevYearTotalTransAmount(getNullableLong(prevYearTotalTransAmount))
                .currYearTotalTransAmount(getNullableLong(currYearTotalTransAmount))
                .lifetimeTotalTransAmount(getNullableLong(lifetimeTotalTransAmount))
                .externalFirstGiftDate(getNullableLong(externalFirstGiftDate))
                .externalFirstGiftAmount(getNullableLong(externalFirstGiftAmount))
                .externalLastGiftDate(getNullableLong(externalLastGiftDate))
                .externalLastGiftAmount(getNullableLong(externalLastGiftAmount))
                .externalLargestGiftDate(getNullableLong(externalLargestGiftDate))
                .externalLargestGiftAmount(getNullableLong(externalLargestGiftAmount))
                .externalYtdGiftAmount(getNullableLong(externalYtdGiftAmount))
                .externalYtdGiftCount(getNullableLong(externalYtdGiftCount))
                .externalLifetimeGiftAmount(getNullableLong(externalLifetimeGiftAmount))
                .externalLifetimeGiftCount(getNullableLong(externalLifetimeGiftCount))
                .prevYearAlertResponseCount(getNullableLong(prevYearAlertResponseCount))
                .currYearAlertResponseCount(getNullableLong(currYearAlertResponseCount))
                .lifetimeAlertResponseCount(getNullableLong(lifetimeAlertResponseCount))
                .memberSinceDate(getNullableLong(memberSinceDate))
                .membershipId(getNullableString(membershipId))
                .membershipLevelId(getNullableLong(membershipLevelId))
                .membershipExpirationDate(getNullableLong(membershipExpirationDate))
                .sustainedMonthlyAmount(getNullableLong(sustainedMonthlyAmount))
                .sustainedStartDate(getNullableLong(sustainedStartDate))
                .sustainedPlannedEndDate(getNullableLong(sustainedPlannedEndDate))
                .active(active == null ? Active.UNKNOWN : Active.getActiveStatusForValue(getNullableString(active)))
                .donorStatus(donorStatus == null ? DonorStatus.UNKNOWN : DonorStatus.getDonorStatusForValue(getNullableString(donorStatus)))
                .emailOptInStatus(emailOptInStatus == null ? EmailOptInStatus.UNKNOWN : EmailOptInStatus.getOptInStatusForValue(getNullableString(emailOptInStatus)))
                .emailStatus(emailStatus == null ? EmailStatus.UNKNOWN : EmailStatus.getEmailStatusForValue(getNullableString(emailStatus)))
                .firstTransTenderType(firstTransTenderType == null ? TransactionTenderType.UNKNOWN : TransactionTenderType.getTransactionTenderTypeForValue(getNullableString(firstTransTenderType)))
                .lastTransTenderType(lastTransTenderType == null ? TransactionTenderType.UNKNOWN : TransactionTenderType.getTransactionTenderTypeForValue(getNullableString(lastTransTenderType)))
                .largestTransTenderType(largestTransTenderType == null ? TransactionTenderType.UNKNOWN : TransactionTenderType.getTransactionTenderTypeForValue(getNullableString(largestTransTenderType)))
                .firstTransPayMethod(firstTransPayMethod == null ? TransactionPaymentMethod.UNKNOWN : TransactionPaymentMethod.getTransactionPaymentMethodForValue(getNullableString(firstTransPayMethod)))
                .lastTransPayMethod(lastTransPayMethod == null ? TransactionPaymentMethod.UNKNOWN : TransactionPaymentMethod.getTransactionPaymentMethodForValue(getNullableString(lastTransPayMethod)))
                .largestTransPayMethod(largestTransPayMethod == null ? TransactionPaymentMethod.UNKNOWN : TransactionPaymentMethod.getTransactionPaymentMethodForValue(getNullableString(largestTransPayMethod)))
                .firstTransDonationType(firstTransDonationType == null ? TransactionDonationType.UNKNOWN : TransactionDonationType.getTransactionDonationTypeForValue(getNullableString(firstTransDonationType)))
                .lastTransDonationType(lastTransDonationType == null ? TransactionDonationType.UNKNOWN : TransactionDonationType.getTransactionDonationTypeForValue(getNullableString(lastTransDonationType)))
                .largestTransDonationType(largestTransDonationType == null ? TransactionDonationType.UNKNOWN : TransactionDonationType.getTransactionDonationTypeForValue(getNullableString(largestTransDonationType)))
                .membershipStatus(membershipStatus == null ? MembershipStatus.UNKNOWN : MembershipStatus.getMembershipStatusForValue(getNullableString(membershipStatus)))
                .sustainedStatus(sustainedStatus == null ? SustainedStatus.UNKNOWN : SustainedStatus.getSustainedStatusForValue(getNullableString(sustainedStatus)))
                .build();
    }

    private String getNullableString(Object field) {
        return field == null ? null : field.toString();
    }

    private Long getNullableLong(Object field) {
        return field == null ? null : Long.parseLong(field.toString());
    }

    private Integer getNullableInt(Object field) {
        return field == null ? null : Integer.parseInt(field.toString());
    }

    private Integer parseValue(Object name) {
        return Integer.parseInt(name.toString());
    }
}
