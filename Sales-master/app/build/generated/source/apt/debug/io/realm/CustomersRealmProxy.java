package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.LinkView;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomersRealmProxy extends com.bartech.sales.sa.data.network.model.Customers
    implements RealmObjectProxy, CustomersRealmProxyInterface {

    static final class CustomersColumnInfo extends ColumnInfo
        implements Cloneable {

        public long idIndex;
        public long totalIndex;
        public long customerNameIndex;

        CustomersColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(3);
            this.idIndex = getValidColumnIndex(path, table, "Customers", "id");
            indicesMap.put("id", this.idIndex);
            this.totalIndex = getValidColumnIndex(path, table, "Customers", "total");
            indicesMap.put("total", this.totalIndex);
            this.customerNameIndex = getValidColumnIndex(path, table, "Customers", "customerName");
            indicesMap.put("customerName", this.customerNameIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final CustomersColumnInfo otherInfo = (CustomersColumnInfo) other;
            this.idIndex = otherInfo.idIndex;
            this.totalIndex = otherInfo.totalIndex;
            this.customerNameIndex = otherInfo.customerNameIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final CustomersColumnInfo clone() {
            return (CustomersColumnInfo) super.clone();
        }

    }
    private CustomersColumnInfo columnInfo;
    private ProxyState<com.bartech.sales.sa.data.network.model.Customers> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("total");
        fieldNames.add("customerName");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    CustomersRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (CustomersColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.bartech.sales.sa.data.network.model.Customers>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$total() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.totalIndex);
    }

    @Override
    public void realmSet$total(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.totalIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.totalIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.totalIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.totalIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$customerName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.customerNameIndex);
    }

    @Override
    public void realmSet$customerName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.customerNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.customerNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.customerNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.customerNameIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Customers")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Customers");
            realmObjectSchema.add("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("total", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("customerName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("Customers");
    }

    public static CustomersColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_Customers")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Customers' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_Customers");
        final long columnCount = table.getColumnCount();
        if (columnCount != 3) {
            if (columnCount < 3) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 3 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 3 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 3 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final CustomersColumnInfo columnInfo = new CustomersColumnInfo(sharedRealm.getPath(), table);

        if (!table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'id' in existing Realm file. @PrimaryKey was added.");
        } else {
            if (table.getPrimaryKey() != columnInfo.idIndex) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key annotation definition was changed, from field " + table.getColumnName(table.getPrimaryKey()) + " to field id");
            }
        }

        if (!columnTypes.containsKey("id")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("id") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'id' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.idIndex) && table.findFirstNull(columnInfo.idIndex) != Table.NO_MATCH) {
            throw new IllegalStateException("Cannot migrate an object with null value in field 'id'. Either maintain the same type for primary key field 'id', or remove the object with null value before migration.");
        }
        if (!table.hasSearchIndex(table.getColumnIndex("id"))) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'id' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
        }
        if (!columnTypes.containsKey("total")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'total' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("total") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'total' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.totalIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'total' is required. Either set @Required to field 'total' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("customerName")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'customerName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("customerName") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'customerName' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.customerNameIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'customerName' is required. Either set @Required to field 'customerName' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_Customers";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.bartech.sales.sa.data.network.model.Customers createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.bartech.sales.sa.data.network.model.Customers obj = null;
        if (update) {
            Table table = realm.getTable(com.bartech.sales.sa.data.network.model.Customers.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.bartech.sales.sa.data.network.model.Customers.class), false, Collections.<String> emptyList());
                    obj = new io.realm.CustomersRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.CustomersRealmProxy) realm.createObjectInternal(com.bartech.sales.sa.data.network.model.Customers.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.CustomersRealmProxy) realm.createObjectInternal(com.bartech.sales.sa.data.network.model.Customers.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("total")) {
            if (json.isNull("total")) {
                ((CustomersRealmProxyInterface) obj).realmSet$total(null);
            } else {
                ((CustomersRealmProxyInterface) obj).realmSet$total((String) json.getString("total"));
            }
        }
        if (json.has("customerName")) {
            if (json.isNull("customerName")) {
                ((CustomersRealmProxyInterface) obj).realmSet$customerName(null);
            } else {
                ((CustomersRealmProxyInterface) obj).realmSet$customerName((String) json.getString("customerName"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.bartech.sales.sa.data.network.model.Customers createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.bartech.sales.sa.data.network.model.Customers obj = new com.bartech.sales.sa.data.network.model.Customers();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomersRealmProxyInterface) obj).realmSet$id(null);
                } else {
                    ((CustomersRealmProxyInterface) obj).realmSet$id((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("total")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomersRealmProxyInterface) obj).realmSet$total(null);
                } else {
                    ((CustomersRealmProxyInterface) obj).realmSet$total((String) reader.nextString());
                }
            } else if (name.equals("customerName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CustomersRealmProxyInterface) obj).realmSet$customerName(null);
                } else {
                    ((CustomersRealmProxyInterface) obj).realmSet$customerName((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.bartech.sales.sa.data.network.model.Customers copyOrUpdate(Realm realm, com.bartech.sales.sa.data.network.model.Customers object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.bartech.sales.sa.data.network.model.Customers) cachedRealmObject;
        } else {
            com.bartech.sales.sa.data.network.model.Customers realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.bartech.sales.sa.data.network.model.Customers.class);
                long pkColumnIndex = table.getPrimaryKey();
                long rowIndex = table.findFirstString(pkColumnIndex, ((CustomersRealmProxyInterface) object).realmGet$id());
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.bartech.sales.sa.data.network.model.Customers.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.CustomersRealmProxy();
                        cache.put(object, (RealmObjectProxy) realmObject);
                    } finally {
                        objectContext.clear();
                    }
                } else {
                    canUpdate = false;
                }
            }

            if (canUpdate) {
                return update(realm, realmObject, object, cache);
            } else {
                return copy(realm, object, update, cache);
            }
        }
    }

    public static com.bartech.sales.sa.data.network.model.Customers copy(Realm realm, com.bartech.sales.sa.data.network.model.Customers newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.bartech.sales.sa.data.network.model.Customers) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.bartech.sales.sa.data.network.model.Customers realmObject = realm.createObjectInternal(com.bartech.sales.sa.data.network.model.Customers.class, ((CustomersRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((CustomersRealmProxyInterface) realmObject).realmSet$total(((CustomersRealmProxyInterface) newObject).realmGet$total());
            ((CustomersRealmProxyInterface) realmObject).realmSet$customerName(((CustomersRealmProxyInterface) newObject).realmGet$customerName());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.bartech.sales.sa.data.network.model.Customers object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.bartech.sales.sa.data.network.model.Customers.class);
        long tableNativePtr = table.getNativeTablePointer();
        CustomersColumnInfo columnInfo = (CustomersColumnInfo) realm.schema.getColumnInfo(com.bartech.sales.sa.data.network.model.Customers.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((CustomersRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, (String)primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$total = ((CustomersRealmProxyInterface)object).realmGet$total();
        if (realmGet$total != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.totalIndex, rowIndex, realmGet$total, false);
        }
        String realmGet$customerName = ((CustomersRealmProxyInterface)object).realmGet$customerName();
        if (realmGet$customerName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.customerNameIndex, rowIndex, realmGet$customerName, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.bartech.sales.sa.data.network.model.Customers.class);
        long tableNativePtr = table.getNativeTablePointer();
        CustomersColumnInfo columnInfo = (CustomersColumnInfo) realm.schema.getColumnInfo(com.bartech.sales.sa.data.network.model.Customers.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.bartech.sales.sa.data.network.model.Customers object = null;
        while (objects.hasNext()) {
            object = (com.bartech.sales.sa.data.network.model.Customers) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.NO_MATCH;
                Object primaryKeyValue = ((CustomersRealmProxyInterface) object).realmGet$id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, (String)primaryKeyValue);
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$total = ((CustomersRealmProxyInterface)object).realmGet$total();
                if (realmGet$total != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.totalIndex, rowIndex, realmGet$total, false);
                }
                String realmGet$customerName = ((CustomersRealmProxyInterface)object).realmGet$customerName();
                if (realmGet$customerName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.customerNameIndex, rowIndex, realmGet$customerName, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.bartech.sales.sa.data.network.model.Customers object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.bartech.sales.sa.data.network.model.Customers.class);
        long tableNativePtr = table.getNativeTablePointer();
        CustomersColumnInfo columnInfo = (CustomersColumnInfo) realm.schema.getColumnInfo(com.bartech.sales.sa.data.network.model.Customers.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((CustomersRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, (String)primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
        }
        cache.put(object, rowIndex);
        String realmGet$total = ((CustomersRealmProxyInterface)object).realmGet$total();
        if (realmGet$total != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.totalIndex, rowIndex, realmGet$total, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.totalIndex, rowIndex, false);
        }
        String realmGet$customerName = ((CustomersRealmProxyInterface)object).realmGet$customerName();
        if (realmGet$customerName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.customerNameIndex, rowIndex, realmGet$customerName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.customerNameIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.bartech.sales.sa.data.network.model.Customers.class);
        long tableNativePtr = table.getNativeTablePointer();
        CustomersColumnInfo columnInfo = (CustomersColumnInfo) realm.schema.getColumnInfo(com.bartech.sales.sa.data.network.model.Customers.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.bartech.sales.sa.data.network.model.Customers object = null;
        while (objects.hasNext()) {
            object = (com.bartech.sales.sa.data.network.model.Customers) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.NO_MATCH;
                Object primaryKeyValue = ((CustomersRealmProxyInterface) object).realmGet$id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, (String)primaryKeyValue);
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
                }
                cache.put(object, rowIndex);
                String realmGet$total = ((CustomersRealmProxyInterface)object).realmGet$total();
                if (realmGet$total != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.totalIndex, rowIndex, realmGet$total, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.totalIndex, rowIndex, false);
                }
                String realmGet$customerName = ((CustomersRealmProxyInterface)object).realmGet$customerName();
                if (realmGet$customerName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.customerNameIndex, rowIndex, realmGet$customerName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.customerNameIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.bartech.sales.sa.data.network.model.Customers createDetachedCopy(com.bartech.sales.sa.data.network.model.Customers realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.bartech.sales.sa.data.network.model.Customers unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.bartech.sales.sa.data.network.model.Customers)cachedObject.object;
            } else {
                unmanagedObject = (com.bartech.sales.sa.data.network.model.Customers)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.bartech.sales.sa.data.network.model.Customers();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((CustomersRealmProxyInterface) unmanagedObject).realmSet$id(((CustomersRealmProxyInterface) realmObject).realmGet$id());
        ((CustomersRealmProxyInterface) unmanagedObject).realmSet$total(((CustomersRealmProxyInterface) realmObject).realmGet$total());
        ((CustomersRealmProxyInterface) unmanagedObject).realmSet$customerName(((CustomersRealmProxyInterface) realmObject).realmGet$customerName());
        return unmanagedObject;
    }

    static com.bartech.sales.sa.data.network.model.Customers update(Realm realm, com.bartech.sales.sa.data.network.model.Customers realmObject, com.bartech.sales.sa.data.network.model.Customers newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((CustomersRealmProxyInterface) realmObject).realmSet$total(((CustomersRealmProxyInterface) newObject).realmGet$total());
        ((CustomersRealmProxyInterface) realmObject).realmSet$customerName(((CustomersRealmProxyInterface) newObject).realmGet$customerName());
        return realmObject;
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomersRealmProxy aCustomers = (CustomersRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aCustomers.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aCustomers.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aCustomers.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
