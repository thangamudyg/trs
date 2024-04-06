package com.trs.util;

import com.trs.entity.Booking;
import com.trs.entity.Sections;
import com.trs.model.Section;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class MyUtil {

    public static List<Section>  getAvailableSeat(List<Booking> bookingList, List<Sections> sectionsList) {

        List<Section> availableSeat = new ArrayList<>();
        if(bookingList.isEmpty()) {
            sectionsList.forEach(v -> {
                Section section = new Section();
                section.setSectionName(v.getSection_name());
                section.setSeatNumber(v.getSeat_number());
                section.setTrainNumber(v.getTrain_number());
                availableSeat.add(section);
            });
        } else {
            sectionsList.forEach(s -> {
                AtomicBoolean found = new AtomicBoolean(false);
                bookingList.forEach(b -> {
                    if(s.getSection_name().equals(b.getSection_name())
                            && s.getSeat_number() == b.getSeat_number()
                            && s.getTrain_number() == b.getTrain_number()){
                        found.set(true);
                    }
                });
                if(!found.get()){
                    Section section = new Section();
                    section.setSectionName(s.getSection_name());
                    section.setSeatNumber(s.getSeat_number());
                    section.setTrainNumber(s.getTrain_number());
                    availableSeat.add(section);
                }
            });
        }
        return availableSeat;
    }
}
