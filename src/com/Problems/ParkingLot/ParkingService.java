//package com.Problems.ParkingLot;
//
//public class ParkingService {
//    public Ticket parkVehicle(Vechile vechile);
//
//    public double removeVehicle(Ticket ticket, Payment payment);
//
//    public void displayAvailableSlots(VehicleType vehicleType);
//}

/*
Core Entities

-> Vehicle

-> ParkingSpot
-> ParkingFloors
-> ParkingLot
-> ParkingStrategy - nearestToGate, default, nearestToLift

-> Ticket

-> PricingStrategy - hourly, min etc
-> Payment

-> ParkingService

--------- impl -------------

-> Vehicle - interface
    -> VehicleType(ENUM) getType()
    -> String getNumber
    -> String getName

        -> Car implement Vehicle
        -> Bike Implement Vehicle


-> ParkingSpot
    ->  ParkingSpot(int spotNumber, VehicleType type) {
        this.spotNumber = spotNumber;
        this.type = type;
    }
    -> isAvailable();
    -> park(Vehicle);
    -> remove();
    -> getVehicle();
    -> getVehicleType();

-> ParkingFloor
    -> ParkingFloor(List<ParkingSpot>, floors)
    -> List<ParkingSpot>
    -> floorNumber
    -> getSlots()
    -> displayFreeSlots(VehicleType type)

-> ParkingLot
    -> list<ParkingFloors>
    -> getFloors()

-> ParkingStrategy - interface
    ->  ParkingSpot findSpot( List<ParkingFloor> floors, Vehicle vehicle);

           -> NearestAvailableStrategy etc

-> Ticket
    -> Ticket(
            String ticketId,
            Vehicle vehicle,
            ParkingSpot parkingSpot,
            long entryTime)
    -> ticketId;
    -> entryTime;
    -> vehicle
    -> ParkingSpot


-> PricingStrategy - interface
    -> double calculatePrice(Ticket ticket);

        -> hourlyBased()
        -> minsBased()

-> Payment - interface
    -> double pay(Ticket ticket, Payment payment)

        -> UPI
        -> Card



--------------------------------------------------------------------------------------------



/*
Core Entities

-> User

-> Notification
-> NotificationPreference
-> NotificationService

-> NotificationSender
   -> Email
   -> SMS
   -> Push
   -> WhatsApp

-> NotificationPolicy

-> NotificationFactory / SenderRegistry

-> NotificationQueue

-> NotificationWorker

-> RetryPolicy

-> RateLimiter

-> DLQ


--------- impl -------------

-> User
    -> userId
    -> name
    -> metadata
    -> NotificationPreference


-> NotificationPreference
    -> emailEnabled
    -> smsEnabled
    -> pushEnabled
    -> whatsappEnabled


-> Notification
    -> notificationId
    -> userId
    -> message
    -> NotificationType
    -> Priority
    -> retryCount
    -> status


-> NotificationType - ENUM
    -> OTP
    -> PAYMENT_FAILURE
    -> MARKETING
    -> GENERAL


-> Priority - ENUM
    -> HIGH
    -> LOW


-> NotificationStatus - ENUM
    -> PENDING
    -> PROCESSING
    -> SUCCESS
    -> FAILED


-> NotificationSender - interface
    -> void send(Notification notification, User user);

        -> EmailSender implements NotificationSender
        -> SmsSender implements NotificationSender
        -> PushSender implements NotificationSender
        -> WhatsAppSender implements NotificationSender


-> NotificationPolicy - interface
    -> List<NotificationType> getAllowedChannels(
            Notification notification,
            User user
       );

        -> OtpNotificationPolicy
        -> PaymentFailurePolicy
        -> MarketingNotificationPolicy


-> NotificationFactory
    -> NotificationSender getSender(NotificationType type);

    OR

-> NotificationSenderRegistry
    -> Map<NotificationType, NotificationSender>

        -> EMAIL  -> EmailSender
        -> SMS    -> SmsSender
        -> PUSH   -> PushSender
        -> WHATSAPP -> WhatsAppSender


-> NotificationService
    -> sendNotification(User user, Notification notification)

    Responsibilities:
        -> Check notification policy
        -> Determine channels
        -> Create/get sender
        -> Push notification to queue


-> NotificationQueue
    -> enqueue(Notification notification)
    -> dequeue()


-> NotificationWorker
    -> process(Notification notification)

    -> EmailWorker
    -> SmsWorker
    -> PushWorker


-> RetryPolicy
    -> maxRetries
    -> initialDelay
    -> backoffMultiplier

    -> shouldRetry(Exception exception)
    -> getNextRetryDelay()


-> RateLimiter
    -> acquire()

    -> EmailRateLimiter
    -> SmsRateLimiter
    -> PushRateLimiter


-> IdempotencyService
    -> isProcessed(notificationId)
    -> markProcessed(notificationId)


-> DeadLetterQueue
    -> move(Notification notification)
    -> retry(Notification notification)


--------- Flow -------------

Client
   |
   v
NotificationService
   |
   v
NotificationPolicy
   |
   v
Determine Channels
   |
   +------> Email Queue
   |
   +------> SMS Queue
   |
   +------> Push Queue
   |
   v
Workers
   |
   v
RateLimiter
   |
   v
NotificationSender
   |
   v
External Provider


--------- Priority -------------

-> High Priority Queue
    -> OTP
    -> Payment Failure
    -> Security Alerts

-> Low Priority Queue
    -> Marketing
    -> Promotional


--------- Failure Handling -------------

Worker
   |
   v
Send Notification
   |
   +---- SUCCESS ---> Mark Processed
   |
   +---- FAILURE
           |
           v
      RetryPolicy
           |
           +---- Retry ---> Exponential Backoff
           |
           +---- Max Retries Reached
                         |
                         v
                        DLQ


--------- Idempotency -------------

Notification ID
      |
      v
Idempotency Store
      |
      +---- Already Processed ---> Skip
      |
      +---- Not Processed ------> Process
                                  |
                                  v
                             Mark Processed


--------- Design Patterns -------------

-> Strategy Pattern
    NotificationSender
        -> EmailSender
        -> SmsSender
        -> PushSender
        -> WhatsAppSender

-> Factory Pattern / Registry
    NotificationFactory
        -> returns appropriate NotificationSender

-> Policy Pattern
    NotificationPolicy
        -> decides which channels are allowed

-> Observer / Event-driven approach
    NotificationService
        -> publishes notification to queue


--------- Important Design Points -------------

-> Asynchronous processing
    Queue + Worker Pool

-> Separate worker pools
    Email workers
    SMS workers
    Push workers

-> Priority handling
    High Priority Queue
    Low Priority Queue

-> Retry
    Exponential Backoff

-> Failure
    Dead Letter Queue

-> Duplicate prevention
    Idempotency using notificationId

-> Provider protection
    Rate Limiter

-> Extensibility
    New channel can be added by implementing
    NotificationSender without modifying
    NotificationService

 */