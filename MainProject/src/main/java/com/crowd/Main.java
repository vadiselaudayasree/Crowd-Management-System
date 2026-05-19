package com.crowd;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.crowd_Entities.Config;
import com.crowd_Entities.Visitor;

import com.crowdService.*;
import com.crowdServiceImpl.*;

public class Main {

	public static void main(String[] args) {

		SessionFactory sf = Config.getSessionFactory();

		Scanner sc = new Scanner(System.in);

		// SERVICES
		VenueService venue = new VenueServiceImpl();

		ZoneService zone = new ZoneServiceImpl();

		VisitorService visitor = new VisitorServiceImpl();

		TimeSlotService slot = new TimeSlotServiceImpl();

		StaffService staff = new StaffServiceImpl();

		BookingService booking = new BookingServiceImpl();

		EntryExitLogService entry =
				new EntryExitLogServiceImpl();

		NotificationService notify =
				new NotificationServiceImpl();

		IncidentService incident =
				new IncidentServiceImpl();

		CrowdAnalyticsService analytics =
				new CrowdAnalyticsServiceImpl();

		while (true) {

			System.out.println(
					"\n===== CROWD MANAGEMENT SYSTEM =====");

			System.out.println(
					"\nSTEP-BY-STEP DATA INSERTION");

			System.out.println("1. Add Venue");

			System.out.println("2. Add Zone");

			System.out.println("3. Register Visitor");

			System.out.println("4. Create Time Slot");

			System.out.println("5. Add Staff");

			System.out.println("6. Create Booking");

			System.out.println("7. Entry/Exit Log");

			System.out.println("8. Send Notification");

			System.out.println("9. Report Incident");

			System.out.println("10. Add Analytics");

			System.out.println("11. Exit");

			System.out.print(
					"\nEnter your choice: ");

			int choice = sc.nextInt();

			try {

				switch (choice) {

				// ADD VENUE
				case 1:

					System.out.println(
							"\nStep 1: Add Venue");

					venue.saveVenue(sf);

					break;

				// ADD ZONE
				case 2:

					System.out.println(
							"\nStep 2: Add Zone");

					System.out.println(
							"Note: Venue must already exist");

					zone.saveZone(sf);

					break;

				// REGISTER VISITOR
				case 3:

					System.out.println(
							"\nStep 3: Register Visitor");

					Visitor v = new Visitor();

					sc.nextLine();

					System.out.println(
							"Enter Full Name:");

					v.setFullName(sc.nextLine());

					System.out.println(
							"Enter Email:");

					v.setEmail(sc.nextLine());

					System.out.println(
							"Enter Phone:");

					v.setPhone(sc.nextLine());

					System.out.println(
							"Enter ID Proof Type:");

					v.setIdProofType(sc.nextLine());

					System.out.println(
							"Enter ID Proof Number:");

					v.setIdProofNumber(sc.nextLine());

					visitor.saveVisitor(sf, v);

					break;

				// CREATE TIME SLOT
				case 4:

					System.out.println(
							"\nStep 4: Create Time Slot");

					System.out.println(
							"Note: Venue must already exist");

					slot.saveTimeSlot(sf);

					break;

				// ADD STAFF
				case 5:

					System.out.println(
							"\nStep 5: Add Staff");

					System.out.println(
							"Note: Venue must already exist");

					staff.saveStaff(sf);

					break;

				// CREATE BOOKING
				case 6:

					System.out.println(
							"\nStep 6: Create Booking");

					System.out.println(
							"Note: Visitor, Slot and Zone must already exist");

					booking.saveBooking(sf);

					break;

				// ENTRY EXIT LOG
				case 7:

					System.out.println(
							"\nStep 7: Entry/Exit Log");

					entry.saveEntryExitLog(sf);

					break;

				// SEND NOTIFICATION
				case 8:

					System.out.println(
							"\nStep 8: Send Notification");

					notify.saveNotification(sf);

					break;

				// REPORT INCIDENT
				case 9:

					System.out.println(
							"\nStep 9: Report Incident");

					incident.saveIncident(sf);

					break;

				// ADD ANALYTICS
				case 10:

					System.out.println(
							"\nStep 10: Add Analytics");

					analytics.saveCrowdAnalytics(sf);

					break;

				// EXIT
				case 11:

					System.out.println(
							"\nProject Closed Successfully");

					sf.close();

					sc.close();

					System.exit(0);

					break;

				default:

					System.out.println(
							"\nInvalid Choice");
				}

			} catch (Exception e) {

				System.out.println(
						"\nError: " + e.getMessage());
			}
		}
	}
}