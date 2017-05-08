"#LightSqlite" 

一款轻量级SQLite框架，非常方便开发过程中对数据库的操作

使用方法：

配置表

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

    // 当数据库版本号更新时，该方法被执行
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}

配置数据库

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

程序中使用:

//---------数据库打开建议放到Application中-----------

PersonalDB db = new PersonalDB(this.getApplicationContext());

db.open(); //打开数据库，程序退出不用关闭

//-----------------------------------------------------

//对表的操作add, find, set, remove方法系列
StudentTable.getsInstance().add(...);

StudentTable.getsInstance().find(...);

StudentTable.getsInstance().set(....);

StudentTable.getsInstance().remove(...);
    


有问题联系QQ: 357406409
