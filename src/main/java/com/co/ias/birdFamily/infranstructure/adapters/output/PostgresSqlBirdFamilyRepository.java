package com.co.ias.birdFamily.infranstructure.adapters.output;

import com.co.ias.birdFamily.birds.application.domain.BirdFamily;
import com.co.ias.birdFamily.birds.application.domain.valueObjs.BirdFamilyId;
import com.co.ias.birdFamily.ports.ouput.BirdFamilyRepository;
import com.co.ias.birdFamily.infranstructure.logSystem.Log;
import com.co.ias.birdFamily.infranstructure.models.BirdFamilyDAO;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class PostgresSqlBirdFamilyRepository implements BirdFamilyRepository {
    private final DataSource dataSource;

    public PostgresSqlBirdFamilyRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void store(BirdFamily birdFamily) {
        String sql ="INSERT INTO tbl_aves (name,scientificname,zonename,quantity) values (?,?,?,?)";
        try {
            PreparedStatement preparedStatement= this.query(sql);

            preparedStatement.setString(1, birdFamily.getName().getValue());
            preparedStatement.setString(2, birdFamily.getScientificName().getValue());
            preparedStatement.setString(3, birdFamily.getZoneName().getValue());
            preparedStatement.setInt(4, birdFamily.getQuantity().getValue());

            preparedStatement.execute();
        }catch (SQLException exception){
            Log log = new Log(exception.getMessage(), "Error query database");
            log.logger();
            throw new RuntimeException("Error query database", exception);
        }
    }

    @Override
    public Optional<BirdFamily> get(BirdFamilyId birdFamilyId) {
        String sql = "SELECT * from tbl_aves where id = ?";

        try {
            PreparedStatement preparedStatement= this.query(sql);
            preparedStatement.setLong(1, birdFamilyId.getValue());
            ResultSet resultSet =preparedStatement.executeQuery();

            if (resultSet.next()){
                BirdFamilyDAO birdFamilyDAO = BirdFamilyDAO.fromResultSet(resultSet);
                BirdFamily birdFamily = birdFamilyDAO.toDomian();
                return Optional.of(birdFamily);
            }else{
                return Optional.empty();
            }

        }catch (SQLException exception){
            Log log = new Log(exception.getMessage(), "Error query database");
            log.logger();
            throw new RuntimeException("Error query database", exception);
        }
    }

    @Override
    public void update(BirdFamily birdFamily) {
        String sql = "Update tbl_aves Set name = ?, scientificname = ?, zonename = ?, quantity = ? Where id = ?";
        try {
            PreparedStatement preparedStatement = this.query(sql);
            preparedStatement.setString(1, birdFamily.getName().getValue());
            preparedStatement.setString(2, birdFamily.getName().getValue());
            preparedStatement.setString(3, birdFamily.getZoneName().getValue());
            preparedStatement.setInt(4, birdFamily.getQuantity().getValue());
            preparedStatement.setLong(5, birdFamily.getId().getValue());

            preparedStatement.executeUpdate();

        }catch (SQLException exception){
            Log log = new Log(exception.getMessage(), "Error queryn database");
            log.logger();
            throw new RuntimeException("Error query database", exception);
        }
    }

    @Override
    public Boolean delete(BirdFamilyId birdFamilyId) {
        String sql = "Delete from tbl_aves Where id = ?";
        try {
            PreparedStatement preparedStatement = this.query(sql);
            preparedStatement.setLong(1, birdFamilyId.getValue());

            Boolean result =preparedStatement.execute();

            return result;
        }catch (SQLException exception){
            Log log = new Log(exception.getMessage(), "Error queryn database");
            log.logger();
            throw new RuntimeException("Error query database", exception);
        }
    }

    private PreparedStatement query(String sql) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement =connection.prepareStatement(sql);
        return preparedStatement;
    }

}
