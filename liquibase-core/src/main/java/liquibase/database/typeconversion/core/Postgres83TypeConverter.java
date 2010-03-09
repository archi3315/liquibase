package liquibase.database.typeconversion.core;

import liquibase.database.Database;
import liquibase.database.structure.type.UUIDType;
import liquibase.exception.DatabaseException;

public class Postgres83TypeConverter extends PostgresTypeConverter {

    @Override
    public int getPriority() {
        return super.getPriority()+1;
    }

    @Override
    public boolean supports(Database database) {
        try {
            return super.supports(database) && database.getDatabaseMajorVersion() >= 8 && database.getDatabaseMinorVersion() >= 3;
        } catch (DatabaseException e) {
            return false;
        }
    }

    @Override
    public UUIDType getUUIDType() {
        return new UUIDType("UUID");
    }

}