
一款轻量级SQLite框架，非常方便开发过程中对数据库的操作

使用方法：

配置表

```java
public class StudentTable extends AbstractTable<StudentItem> {

    private final static String TABLE_NAME = "student"; // 学生表

    private static StudentTable sInstance;

    private StudentTable() {}

    public static StudentTable getsInstance() {
        if (sInstance == null) {
            sInstance = new StudentTable();
        }
        return sInstance;
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
    
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //注：表字段增加不需要在这里操作，只需要在StudentItem中字义新变量即可
        // 对表的旧字段进行修改需要在这里操作
    }
}
```

配置学生实体类

```java
public class StudentItem {  
  
    public static final String FIELD_S_ID = "s_id";  
    public static final String FIELD_S_NAME = "s_name";  
    public static final String FIELD_S_AGE = "age";  
    public static final String FIELD_S_CLASS = "class";  
  
    //---------------数据库版本为1时的字段列表
    @Column(name = FIELD_S_ID, unique = true, index = true, notNull = true) 
    private int id;  
  
    @Column(name = FIELD_S_NAME, notNull = true)  
    private String name;  
  
    @Column(name = FIELD_S_AGE, notNull = true)  
    private int age;  
  
    @Column(name = FIELD_S_CLASS)  
    private String inClass;  
    
    //-----------------数据库版本号为2时的新增字段列表---------------
    //表字段增加时，直接往下写，会自动为表增加字段
  
    //GET and SET 方法就省略了
    .....  
}  
```
配置数据库
```java
public class PersonalDB extends AbstractDBHelper {

    // 数据库名
    private final String DB_NAME = "MY_DB.db";

    // 数据库版本
    // [VR = 1 数据库初版]
    private final int DB_VERSION = 1;
  
    public PersonalDB(Context context) {
        super(context);
    }

    @Override
    public String getDataBaseName() {
        return DB_NAME;
    }

    @Override
    public int getDataBaseVersion() {
        return DB_VERSION;
    }

    //返回MY_DB.db数据库所有的表,后续增加表直接在这里添加
    @Override
    public List<AbstractTable<?>> getTables() {
        List<AbstractTable<?>> list = new ArrayList<AbstractTable<?>>();
        list.add(StudentTable.getsInstance()); //学生表
        list.add(TeacherTable.getsInstance()); //老师表
        //后续有新表继续添加
        //.........
        return list;
    }
}
```
程序中使用:
```java
//---------数据库打开建议放到Application中-----------
PersonalDB db = new PersonalDB(this.getApplicationContext());
db.open(); //打开数据库，程序退出不用关闭
//-----------------------------------------------------
//对表的操作add, find, set, remove方法系列
StudentTable.getsInstance().add(...);
StudentTable.getsInstance().find(...);
StudentTable.getsInstance().set(....);
StudentTable.getsInstance().remove(...);
```


遇到问题和好的建议请联系QQ: 357406409 在此谢过
