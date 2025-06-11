package com.sst.movieflex.repositories;

import com.sst.movieflex.models.Show;
import com.sst.movieflex.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long> {
    public List<ShowSeatType> findAllByShowId(Long showId);
}
