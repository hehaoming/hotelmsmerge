package com.hotelms.service.Impl;
        import com.hotelms.bean.ItemBean;
        import com.hotelms.bean.Passenger;
        import com.hotelms.bean.PassengerVO;

        import com.hotelms.dao.ItemMapper;
        import com.hotelms.dao.PassengerMapper;
        import com.hotelms.service.PassengerService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.HashMap;
        import java.util.List;

@Service("service")
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    PassengerMapper passengerdao;

    @Autowired
    ItemMapper itemdao;

        @Autowired
    PassengerMapper passengerMapper;

    @Autowired
    ItemMapper itemMapper;
    @Override
    public int AddPassenger(Passenger passenger) {
        int i = passengerdao.addpassenge(passenger);
        return i;
    }

    @Override
    public List<ItemBean> getListOfItem(int itemID) {
        List<ItemBean> listGender = itemdao.getListOfItem(itemID);
        return listGender;
    }

    @Override
    public List<PassengerVO> selectAllPassenger(int currentage, int limit) {

        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("limit",limit);
        stringIntegerHashMap.put("offset",(currentage - 1)*limit);
        List<PassengerVO> passengers = passengerdao.selectAllPassenger(stringIntegerHashMap);
        return passengers;
    }

    @Override
    public List<PassengerVO> selectPassengerByName(String name,int currentage,int limit) {
        HashMap<String, Object> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("limit",limit);
        stringIntegerHashMap.put("offset",(currentage - 1)*limit);
        stringIntegerHashMap.put("NAME",name);
        List<PassengerVO> passengers = passengerdao.selectPassengerByName(stringIntegerHashMap);
//        LinkedList<HashMap> passengersList = new LinkedList<>();
//        for (Passenger passenger : passengers) {
//            HashMap<String, String> stringStringHashMap = new HashMap<>();
//            stringStringHashMap.put("",)
//        }
        return passengers;
    }

    @Override
    public int deleteByPrimaryKey(String[] arrs) {
        int i = passengerdao.deleteByPrimaryKey(arrs);
        return i;
    }

    @Override
    public Passenger selectByPrimaryKey(Integer id) {
        Passenger passenger = passengerdao.selectByPrimaryKey(id);
        return passenger;
    }

    @Override
    public int updateByPrimaryKey(Passenger passenger) {
        int i = passengerdao.updateByPrimaryKey(passenger);
        return i;
    }

    @Override
    public int selectAccount() {
        int i = passengerdao.selectAccount();
        return i;
    }

      /**
     * 查询所有的旅客信息，并将旅客信息中的性别信息字段、证件信息名称字段查询并加入
     * @return 旅客信息集合
     */
    public List<Passenger> findAllPassengersWithPaperNameAndSexName() {

        List<Passenger> passengers = passengerMapper.selectAllPassengers();
        for (Passenger passenger : passengers) {
            //查询性别字段
            passenger.setGenderName(itemMapper.getOneNameOfItem(Integer.parseInt(passenger.getGenderID())));
            //查询证件名称字段
            passenger.setPapersName(itemMapper.getOneNameOfItem(passenger.getPapersID()));
        }
        return passengers;
    }

    /**
     * 根据旅客ID查询旅客电话信息
     * @param id
     * @return 旅客电话信息
     */
    public String findPassengerPhoneNumberByID(int id) {

        String phoneNumber = passengerMapper.selectPassengerPhoneNumberByID(id);
        return phoneNumber;
    }
}
