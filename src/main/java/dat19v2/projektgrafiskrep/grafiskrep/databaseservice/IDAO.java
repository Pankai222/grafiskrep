package dat19v2.projektgrafiskrep.grafiskrep.databaseservice;

import java.util.List;

 public interface IDAO {
    List selectAll();
    void delete();
    void insert();
    void update();
    void select();
}
