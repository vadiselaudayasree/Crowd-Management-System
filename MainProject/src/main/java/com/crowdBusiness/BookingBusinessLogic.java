package com.crowdBusiness;

import com.crowd_Entities.Time_slot;
import com.crowd_Entities.Zone;

public class BookingBusinessLogic {

    // ✅ UPDATE COUNTS AFTER BOOKING
    public static void updateCounts(Time_slot slot, Zone zone) {

        // Increase booked count in slot
        slot.setBookedCount(
                slot.getBookedCount() + 1
        );

        // Increase current count in zone
        zone.setCurrentCount(
                zone.getCurrentCount() + 1
        );

        // ✅ DISPLAY UPDATED COUNTS
        System.out.println("\n===== LIVE CROWD UPDATE =====");

        System.out.println(
                "Updated Slot Count : "
                        + slot.getBookedCount()
        );

        System.out.println(
                "Updated Zone Count : "
                        + zone.getCurrentCount()
        );

        // ✅ DISPLAY REMAINING CAPACITY

        int remainingSlotCapacity =
                slot.getMaxCapacity()
                        - slot.getBookedCount();

        int remainingZoneCapacity =
                zone.getMaxCapacity()
                        - zone.getCurrentCount();

        System.out.println(
                "Remaining Slot Capacity : "
                        + remainingSlotCapacity
        );

        System.out.println(
                "Remaining Zone Capacity : "
                        + remainingZoneCapacity
        );

        System.out.println(
                "================================"
        );
    }

    // ✅ CHECK SLOT AVAILABILITY
    public static boolean isSlotAvailable(Time_slot slot) {

        return slot.getBookedCount()
                < slot.getMaxCapacity();
    }

    // ✅ CHECK ZONE AVAILABILITY
    public static boolean isZoneAvailable(Zone zone) {

        return zone.getCurrentCount()
                < zone.getMaxCapacity();
    }
}