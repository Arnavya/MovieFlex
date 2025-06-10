package com.sst.movieflex.dtos;

import com.sst.movieflex.models.ShowSeat;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateBookingRequestDto {
    private Long userId;
    private List<Long> showSeatsIds;

}
