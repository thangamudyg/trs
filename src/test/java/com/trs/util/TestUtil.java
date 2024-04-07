package com.trs.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trs.entity.Person;
import com.trs.entity.Sections;
import com.trs.entity.Train;
import com.trs.model.Boarding;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Thangamudy Gurusamy
 * Date : 07/04/24
 * Package : com.trs.util
 */
public class TestUtil {

    @Before
    public void setUp(){

    }
    public static Boarding getBoarding() throws JsonProcessingException {
        String boardingPayload = "{\n" +
                "  \"train_number\": 1122,\n" +
                "  \"from_station\": \"London\",\n" +
                "  \"to_station\": \"France\"\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        return  mapper.readValue(boardingPayload, Boarding.class);
    }

    public static Optional<Person> getPerson() {
        Person person = new Person();
        person.setEmail_address("john@gmail.com");
        person.setId(1);
        person.setFirst_name("John");
        person.setLast_name("Methew");
        return Optional.of(person);
    }

    public static List<com.trs.entity.Booking > getBookingList() {
        com.trs.entity.Booking booking = new com.trs.entity.Booking();
        booking.setSection_name("A");
        booking.setId(1);
        booking.setTrain_number(1122);
        booking.setSeat_number(1);
        List<com.trs.entity.Booking> bookingList = new ArrayList<>();
        bookingList.add(booking);
        return  bookingList;
    }

    public static com.trs.model.Booking getBooking() {
        com.trs.model.Booking booking = new com.trs.model.Booking();
        booking.setSectionName("A");
        booking.setTrainNumber(1122);
        booking.setSeatNumber("1");
        booking.setReceiptId(1);
        return  booking;
    }

    public static com.trs.entity.Booking getBookingEntity() {
        com.trs.entity.Booking booking = new com.trs.entity.Booking();
        booking.setSection_name("A");
        booking.setTrain_number(1122);
        booking.setSeat_number(1);
        booking.setReceipt_id(1);
        booking.setUser_id(1);
        return  booking;
    }

    public static List<com.trs.entity.Booking> getBookingEntityList() {
        List<com.trs.entity.Booking> list = new ArrayList<>();
        list.add(getBookingEntity());
        return list;
    }
    public static List<Sections>  getSections() {
        Sections sections = new Sections();
        sections.setSection_name("A");
        sections.setId(1);
        sections.setTrain_number(1122);
        sections.setSeat_number(2);
        Sections sections2 = new Sections();
        sections2.setSection_name("A");
        sections2.setId(1);
        sections2.setTrain_number(1122);
        sections2.setSeat_number(1);
        List<Sections> sectionsList = new ArrayList<>();
        sectionsList.add(sections);
        sectionsList.add(sections2);
        return  sectionsList;
    }
    public static Optional<Sections>  getSection() {
        Sections sections = new Sections();
        sections.setSection_name("A");
        sections.setId(1);
        sections.setTrain_number(1122);
        sections.setSeat_number(2);
        return  Optional.of(sections);
    }

    public static com.trs.model.Receipt getReceipt(){
        com.trs.model.Receipt receipt = new com.trs.model.Receipt();
        String receiptPayload = "{\n" +
                "    \"receipt_id\": 1,\n" +
                "    \"from_station\": \"London\",\n" +
                "    \"to_station\": \"France\",\n" +
                "    \"price\": 5.0,\n" +
                "    \"booking\": {\n" +
                "        \"train_number\": 1122,\n" +
                "        \"section_name\": \"A \",\n" +
                "        \"seat_number\": \"1\"\n" +
                "    },\n" +
                "    \"user\": {\n" +
                "        \"first_name\": \"John\",\n" +
                "        \"last_name\": \"Mathew\",\n" +
                "        \"email\": \"john@gmail.com\"\n" +
                "    }\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(receiptPayload, com.trs.model.Receipt.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static Optional<com.trs.entity.Receipt> getReceiptEntity() {
        com.trs.entity.Receipt receiptEntity = new com.trs.entity.Receipt();
        com.trs.model.Receipt receiptModel = getReceipt();
        receiptEntity.setReceipt_id(receiptModel.getReceiptId());
        receiptEntity.setPrice(5.00);
        receiptEntity.setPrice(receiptModel.getPrice());
        receiptEntity.setTo_station(receiptModel.getToStation());
        receiptEntity.setFrom_station(receiptModel.getFromStation());
        com.trs.entity.Booking bookingEnity = new com.trs.entity.Booking();
        com.trs.model.Booking bookingModel = receiptModel.getBooking();
        bookingEnity.setSeat_number(Integer.valueOf(bookingModel.getSeatNumber()));
        bookingEnity.setSection_name(bookingModel.getSectionName());
        receiptEntity.setBooking(bookingEnity);
        return Optional.of(receiptEntity);
    }
    public static List<com.trs.entity.Receipt> getReceiptEntityList(){
        List<com.trs.entity.Receipt> list = new ArrayList<>();
        list.add(getReceiptEntity().get());
        return list;
    }

    public static Optional<Train> getTrain() {
        Train train = new Train();
        train.setId(1122);
        train.setTrain_name("Express");
        return Optional.of(train);
    }
}
