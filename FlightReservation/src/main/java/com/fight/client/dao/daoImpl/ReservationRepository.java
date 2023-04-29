public interface ReservationRepository {
    List<Reservation> findAll();
    Reservation findById(int id);
    Reservation save(Reservation reservation);
    void delete(int id);
}
