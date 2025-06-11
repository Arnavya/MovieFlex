package com.sst.movieflex.services;

import com.sst.movieflex.models.Show;
import com.sst.movieflex.models.ShowSeat;
import com.sst.movieflex.models.ShowSeatType;
import com.sst.movieflex.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingPriceCalculatorService {
    private ShowSeatTypeRepository showSeatTypeRepository;

    public BookingPriceCalculatorService(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }
     public double calculatePrice(List<ShowSeat> showSeats){
         double amount = 0.0;
         Show show = showSeats.getFirst().getShow();
         List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShowId(show.getId());

         for(ShowSeat showSeat: showSeats){
             for(ShowSeatType showSeatType: showSeatTypes){
                 if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())){
                     amount += showSeatType.getPrice();
                     break;
                 }
             }
         }
         return amount;
     }
}
