@Repository
public class ReservationRepositoryImpl implements ReservationRepository {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    public ReservationRepositoryImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    @Override
    public List<Reservation> findAll() {
        String query = "SELECT * FROM reservation";
        RowMapper<Reservation> rowMapper = new BeanPropertyRowMapper<>(Reservation.class);
        return jdbcTemplate.query(query, rowMapper);
    }
    @Override
    public Optional<Reservation> findById(int id) {
        String query = "SELECT * FROM reservation WHERE id = ?";
        RowMapper<Reservation> rowMapper = new BeanPropertyRowMapper<>(Reservation.class);
        List<Reservation> reservations = jdbcTemplate.query(query, rowMapper, id);
        return reservations.isEmpty() ? Optional.empty() : Optional.of(reservations.get(0));
    }
    @Override
    public Reservation save(Reservation reservation) {
        String query = "INSERT INTO reservation(CHECKED_IN, NUMBER_OF_BAGS, PASSENGER_ID, FLIGHT_ID) VALUES(:checkedIn, :numberOfBags, :passengerId, :flightId)";
        SqlParameterSource parameters = new BeanPropertySqlParameterSource(reservation);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(query, parameters, keyHolder);
        reservation.setId(keyHolder.getKey().intValue());
        return reservation;
    }
    @Override
    public void deleteById(int id) {
        String query = "DELETE FROM reservation WHERE id=?";
        jdbcTemplate.update(query, id);
    }
    @Override
    public Reservation bookFlight(ReservationRequest reservationRequest) {
        return null;
    }
}
