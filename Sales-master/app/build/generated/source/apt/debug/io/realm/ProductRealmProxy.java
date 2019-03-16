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

public class ProductRealmProxy extends com.bartech.sales.sa.data.network.model.Product
    implements RealmObjectProxy, ProductRealmProxyInterface {

    static final class ProductColumnInfo extends ColumnInfo
        implements Cloneable {

        public long idIndex;
        public long productNameIndex;
        public long unitIndex;
        public long quantumIndex;
        public long priceIndex;
        public long totalIndex;
        public long addedToCartIndex;

        ProductColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(7);
            this.idIndex = getValidColumnIndex(path, table, "Product", "id");
            indicesMap.put("id", this.idIndex);
            this.productNameIndex = getValidColumnIndex(path, table, "Product", "productName");
            indicesMap.put("productName", this.productNameIndex);
            this.unitIndex = getValidColumnIndex(path, table, "Product", "unit");
            indicesMap.put("unit", this.unitIndex);
            this.quantumIndex = getValidColumnIndex(path, table, "Product", "quantum");
            indicesMap.put("quantum", this.quantumIndex);
            this.priceIndex = getValidColumnIndex(path, table, "Product", "price");
            indicesMap.put("price", this.priceIndex);
            this.totalIndex = getValidColumnIndex(path, table, "Product", "total");
            indicesMap.put("total", this.totalIndex);
            this.addedToCartIndex = getValidColumnIndex(path, table, "Product", "addedToCart");
            indicesMap.put("addedToCart", this.addedToCartIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final ProductColumnInfo otherInfo = (ProductColumnInfo) other;
            this.idIndex = otherInfo.idIndex;
            this.productNameIndex = otherInfo.productNameIndex;
            this.unitIndex = otherInfo.unitIndex;
            this.quantumIndex = otherInfo.quantumIndex;
            this.priceIndex = otherInfo.priceIndex;
            this.totalIndex = otherInfo.totalIndex;
            this.addedToCartIndex = otherInfo.addedToCartIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final ProductColumnInfo clone() {
            return (ProductColumnInfo) super.clone();
        }

    }
    private ProductColumnInfo columnInfo;
    private ProxyState<com.bartech.sales.sa.data.network.model.Product> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("productName");
        fieldNames.add("unit");
        fieldNames.add("quantum");
        fieldNames.add("price");
        fieldNames.add("total");
        fieldNames.add("addedToCart");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    ProductRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ProductColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.bartech.sales.sa.data.network.model.Product>(this);
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
    public String realmGet$productName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.productNameIndex);
    }

    @Override
    public void realmSet$productName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.productNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.productNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.productNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.productNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$unit() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.unitIndex);
    }

    @Override
    public void realmSet$unit(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.unitIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.unitIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.unitIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.unitIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$quantum() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.quantumIndex);
    }

    @Override
    public void realmSet$quantum(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.quantumIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.quantumIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.quantumIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.quantumIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$price() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.priceIndex);
    }

    @Override
    public void realmSet$price(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.priceIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.priceIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.priceIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.priceIndex, value);
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
    public boolean realmGet$addedToCart() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.addedToCartIndex);
    }

    @Override
    public void realmSet$addedToCart(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.addedToCartIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.addedToCartIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Product")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Product");
            realmObjectSchema.add("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("productName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("unit", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("quantum", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("price", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("total", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("addedToCart", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("Product");
    }

    public static ProductColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_Product")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Product' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_Product");
        final long columnCount = table.getColumnCount();
        if (columnCount != 7) {
            if (columnCount < 7) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 7 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 7 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 7 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final ProductColumnInfo columnInfo = new ProductColumnInfo(sharedRealm.getPath(), table);

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
        if (!columnTypes.containsKey("productName")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'productName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("productName") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'productName' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.productNameIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'productName' is required. Either set @Required to field 'productName' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("unit")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'unit' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("unit") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'unit' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.unitIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'unit' is required. Either set @Required to field 'unit' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("quantum")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'quantum' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("quantum") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'quantum' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.quantumIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'quantum' is required. Either set @Required to field 'quantum' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("price")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'price' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("price") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'price' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.priceIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'price' is required. Either set @Required to field 'price' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("addedToCart")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'addedToCart' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("addedToCart") != RealmFieldType.BOOLEAN) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'boolean' for field 'addedToCart' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.addedToCartIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'addedToCart' does support null values in the existing Realm file. Use corresponding boxed type for field 'addedToCart' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_Product";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.bartech.sales.sa.data.network.model.Product createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.bartech.sales.sa.data.network.model.Product obj = null;
        if (update) {
            Table table = realm.getTable(com.bartech.sales.sa.data.network.model.Product.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.bartech.sales.sa.data.network.model.Product.class), false, Collections.<String> emptyList());
                    obj = new io.realm.ProductRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.ProductRealmProxy) realm.createObjectInternal(com.bartech.sales.sa.data.network.model.Product.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.ProductRealmProxy) realm.createObjectInternal(com.bartech.sales.sa.data.network.model.Product.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("productName")) {
            if (json.isNull("productName")) {
                ((ProductRealmProxyInterface) obj).realmSet$productName(null);
            } else {
                ((ProductRealmProxyInterface) obj).realmSet$productName((String) json.getString("productName"));
            }
        }
        if (json.has("unit")) {
            if (json.isNull("unit")) {
                ((ProductRealmProxyInterface) obj).realmSet$unit(null);
            } else {
                ((ProductRealmProxyInterface) obj).realmSet$unit((String) json.getString("unit"));
            }
        }
        if (json.has("quantum")) {
            if (json.isNull("quantum")) {
                ((ProductRealmProxyInterface) obj).realmSet$quantum(null);
            } else {
                ((ProductRealmProxyInterface) obj).realmSet$quantum((String) json.getString("quantum"));
            }
        }
        if (json.has("price")) {
            if (json.isNull("price")) {
                ((ProductRealmProxyInterface) obj).realmSet$price(null);
            } else {
                ((ProductRealmProxyInterface) obj).realmSet$price((String) json.getString("price"));
            }
        }
        if (json.has("total")) {
            if (json.isNull("total")) {
                ((ProductRealmProxyInterface) obj).realmSet$total(null);
            } else {
                ((ProductRealmProxyInterface) obj).realmSet$total((String) json.getString("total"));
            }
        }
        if (json.has("addedToCart")) {
            if (json.isNull("addedToCart")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'addedToCart' to null.");
            } else {
                ((ProductRealmProxyInterface) obj).realmSet$addedToCart((boolean) json.getBoolean("addedToCart"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.bartech.sales.sa.data.network.model.Product createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.bartech.sales.sa.data.network.model.Product obj = new com.bartech.sales.sa.data.network.model.Product();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductRealmProxyInterface) obj).realmSet$id(null);
                } else {
                    ((ProductRealmProxyInterface) obj).realmSet$id((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("productName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductRealmProxyInterface) obj).realmSet$productName(null);
                } else {
                    ((ProductRealmProxyInterface) obj).realmSet$productName((String) reader.nextString());
                }
            } else if (name.equals("unit")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductRealmProxyInterface) obj).realmSet$unit(null);
                } else {
                    ((ProductRealmProxyInterface) obj).realmSet$unit((String) reader.nextString());
                }
            } else if (name.equals("quantum")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductRealmProxyInterface) obj).realmSet$quantum(null);
                } else {
                    ((ProductRealmProxyInterface) obj).realmSet$quantum((String) reader.nextString());
                }
            } else if (name.equals("price")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductRealmProxyInterface) obj).realmSet$price(null);
                } else {
                    ((ProductRealmProxyInterface) obj).realmSet$price((String) reader.nextString());
                }
            } else if (name.equals("total")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductRealmProxyInterface) obj).realmSet$total(null);
                } else {
                    ((ProductRealmProxyInterface) obj).realmSet$total((String) reader.nextString());
                }
            } else if (name.equals("addedToCart")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'addedToCart' to null.");
                } else {
                    ((ProductRealmProxyInterface) obj).realmSet$addedToCart((boolean) reader.nextBoolean());
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

    public static com.bartech.sales.sa.data.network.model.Product copyOrUpdate(Realm realm, com.bartech.sales.sa.data.network.model.Product object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.bartech.sales.sa.data.network.model.Product) cachedRealmObject;
        } else {
            com.bartech.sales.sa.data.network.model.Product realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.bartech.sales.sa.data.network.model.Product.class);
                long pkColumnIndex = table.getPrimaryKey();
                long rowIndex = table.findFirstString(pkColumnIndex, ((ProductRealmProxyInterface) object).realmGet$id());
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.bartech.sales.sa.data.network.model.Product.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.ProductRealmProxy();
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

    public static com.bartech.sales.sa.data.network.model.Product copy(Realm realm, com.bartech.sales.sa.data.network.model.Product newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.bartech.sales.sa.data.network.model.Product) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.bartech.sales.sa.data.network.model.Product realmObject = realm.createObjectInternal(com.bartech.sales.sa.data.network.model.Product.class, ((ProductRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((ProductRealmProxyInterface) realmObject).realmSet$productName(((ProductRealmProxyInterface) newObject).realmGet$productName());
            ((ProductRealmProxyInterface) realmObject).realmSet$unit(((ProductRealmProxyInterface) newObject).realmGet$unit());
            ((ProductRealmProxyInterface) realmObject).realmSet$quantum(((ProductRealmProxyInterface) newObject).realmGet$quantum());
            ((ProductRealmProxyInterface) realmObject).realmSet$price(((ProductRealmProxyInterface) newObject).realmGet$price());
            ((ProductRealmProxyInterface) realmObject).realmSet$total(((ProductRealmProxyInterface) newObject).realmGet$total());
            ((ProductRealmProxyInterface) realmObject).realmSet$addedToCart(((ProductRealmProxyInterface) newObject).realmGet$addedToCart());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.bartech.sales.sa.data.network.model.Product object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.bartech.sales.sa.data.network.model.Product.class);
        long tableNativePtr = table.getNativeTablePointer();
        ProductColumnInfo columnInfo = (ProductColumnInfo) realm.schema.getColumnInfo(com.bartech.sales.sa.data.network.model.Product.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((ProductRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, (String)primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$productName = ((ProductRealmProxyInterface)object).realmGet$productName();
        if (realmGet$productName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productNameIndex, rowIndex, realmGet$productName, false);
        }
        String realmGet$unit = ((ProductRealmProxyInterface)object).realmGet$unit();
        if (realmGet$unit != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.unitIndex, rowIndex, realmGet$unit, false);
        }
        String realmGet$quantum = ((ProductRealmProxyInterface)object).realmGet$quantum();
        if (realmGet$quantum != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.quantumIndex, rowIndex, realmGet$quantum, false);
        }
        String realmGet$price = ((ProductRealmProxyInterface)object).realmGet$price();
        if (realmGet$price != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.priceIndex, rowIndex, realmGet$price, false);
        }
        String realmGet$total = ((ProductRealmProxyInterface)object).realmGet$total();
        if (realmGet$total != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.totalIndex, rowIndex, realmGet$total, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.addedToCartIndex, rowIndex, ((ProductRealmProxyInterface)object).realmGet$addedToCart(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.bartech.sales.sa.data.network.model.Product.class);
        long tableNativePtr = table.getNativeTablePointer();
        ProductColumnInfo columnInfo = (ProductColumnInfo) realm.schema.getColumnInfo(com.bartech.sales.sa.data.network.model.Product.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.bartech.sales.sa.data.network.model.Product object = null;
        while (objects.hasNext()) {
            object = (com.bartech.sales.sa.data.network.model.Product) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.NO_MATCH;
                Object primaryKeyValue = ((ProductRealmProxyInterface) object).realmGet$id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, (String)primaryKeyValue);
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$productName = ((ProductRealmProxyInterface)object).realmGet$productName();
                if (realmGet$productName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.productNameIndex, rowIndex, realmGet$productName, false);
                }
                String realmGet$unit = ((ProductRealmProxyInterface)object).realmGet$unit();
                if (realmGet$unit != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.unitIndex, rowIndex, realmGet$unit, false);
                }
                String realmGet$quantum = ((ProductRealmProxyInterface)object).realmGet$quantum();
                if (realmGet$quantum != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.quantumIndex, rowIndex, realmGet$quantum, false);
                }
                String realmGet$price = ((ProductRealmProxyInterface)object).realmGet$price();
                if (realmGet$price != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.priceIndex, rowIndex, realmGet$price, false);
                }
                String realmGet$total = ((ProductRealmProxyInterface)object).realmGet$total();
                if (realmGet$total != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.totalIndex, rowIndex, realmGet$total, false);
                }
                Table.nativeSetBoolean(tableNativePtr, columnInfo.addedToCartIndex, rowIndex, ((ProductRealmProxyInterface)object).realmGet$addedToCart(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.bartech.sales.sa.data.network.model.Product object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.bartech.sales.sa.data.network.model.Product.class);
        long tableNativePtr = table.getNativeTablePointer();
        ProductColumnInfo columnInfo = (ProductColumnInfo) realm.schema.getColumnInfo(com.bartech.sales.sa.data.network.model.Product.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((ProductRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, (String)primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
        }
        cache.put(object, rowIndex);
        String realmGet$productName = ((ProductRealmProxyInterface)object).realmGet$productName();
        if (realmGet$productName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productNameIndex, rowIndex, realmGet$productName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.productNameIndex, rowIndex, false);
        }
        String realmGet$unit = ((ProductRealmProxyInterface)object).realmGet$unit();
        if (realmGet$unit != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.unitIndex, rowIndex, realmGet$unit, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.unitIndex, rowIndex, false);
        }
        String realmGet$quantum = ((ProductRealmProxyInterface)object).realmGet$quantum();
        if (realmGet$quantum != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.quantumIndex, rowIndex, realmGet$quantum, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.quantumIndex, rowIndex, false);
        }
        String realmGet$price = ((ProductRealmProxyInterface)object).realmGet$price();
        if (realmGet$price != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.priceIndex, rowIndex, realmGet$price, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.priceIndex, rowIndex, false);
        }
        String realmGet$total = ((ProductRealmProxyInterface)object).realmGet$total();
        if (realmGet$total != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.totalIndex, rowIndex, realmGet$total, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.totalIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.addedToCartIndex, rowIndex, ((ProductRealmProxyInterface)object).realmGet$addedToCart(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.bartech.sales.sa.data.network.model.Product.class);
        long tableNativePtr = table.getNativeTablePointer();
        ProductColumnInfo columnInfo = (ProductColumnInfo) realm.schema.getColumnInfo(com.bartech.sales.sa.data.network.model.Product.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.bartech.sales.sa.data.network.model.Product object = null;
        while (objects.hasNext()) {
            object = (com.bartech.sales.sa.data.network.model.Product) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.NO_MATCH;
                Object primaryKeyValue = ((ProductRealmProxyInterface) object).realmGet$id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, (String)primaryKeyValue);
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
                }
                cache.put(object, rowIndex);
                String realmGet$productName = ((ProductRealmProxyInterface)object).realmGet$productName();
                if (realmGet$productName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.productNameIndex, rowIndex, realmGet$productName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.productNameIndex, rowIndex, false);
                }
                String realmGet$unit = ((ProductRealmProxyInterface)object).realmGet$unit();
                if (realmGet$unit != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.unitIndex, rowIndex, realmGet$unit, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.unitIndex, rowIndex, false);
                }
                String realmGet$quantum = ((ProductRealmProxyInterface)object).realmGet$quantum();
                if (realmGet$quantum != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.quantumIndex, rowIndex, realmGet$quantum, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.quantumIndex, rowIndex, false);
                }
                String realmGet$price = ((ProductRealmProxyInterface)object).realmGet$price();
                if (realmGet$price != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.priceIndex, rowIndex, realmGet$price, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.priceIndex, rowIndex, false);
                }
                String realmGet$total = ((ProductRealmProxyInterface)object).realmGet$total();
                if (realmGet$total != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.totalIndex, rowIndex, realmGet$total, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.totalIndex, rowIndex, false);
                }
                Table.nativeSetBoolean(tableNativePtr, columnInfo.addedToCartIndex, rowIndex, ((ProductRealmProxyInterface)object).realmGet$addedToCart(), false);
            }
        }
    }

    public static com.bartech.sales.sa.data.network.model.Product createDetachedCopy(com.bartech.sales.sa.data.network.model.Product realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.bartech.sales.sa.data.network.model.Product unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.bartech.sales.sa.data.network.model.Product)cachedObject.object;
            } else {
                unmanagedObject = (com.bartech.sales.sa.data.network.model.Product)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.bartech.sales.sa.data.network.model.Product();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((ProductRealmProxyInterface) unmanagedObject).realmSet$id(((ProductRealmProxyInterface) realmObject).realmGet$id());
        ((ProductRealmProxyInterface) unmanagedObject).realmSet$productName(((ProductRealmProxyInterface) realmObject).realmGet$productName());
        ((ProductRealmProxyInterface) unmanagedObject).realmSet$unit(((ProductRealmProxyInterface) realmObject).realmGet$unit());
        ((ProductRealmProxyInterface) unmanagedObject).realmSet$quantum(((ProductRealmProxyInterface) realmObject).realmGet$quantum());
        ((ProductRealmProxyInterface) unmanagedObject).realmSet$price(((ProductRealmProxyInterface) realmObject).realmGet$price());
        ((ProductRealmProxyInterface) unmanagedObject).realmSet$total(((ProductRealmProxyInterface) realmObject).realmGet$total());
        ((ProductRealmProxyInterface) unmanagedObject).realmSet$addedToCart(((ProductRealmProxyInterface) realmObject).realmGet$addedToCart());
        return unmanagedObject;
    }

    static com.bartech.sales.sa.data.network.model.Product update(Realm realm, com.bartech.sales.sa.data.network.model.Product realmObject, com.bartech.sales.sa.data.network.model.Product newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((ProductRealmProxyInterface) realmObject).realmSet$productName(((ProductRealmProxyInterface) newObject).realmGet$productName());
        ((ProductRealmProxyInterface) realmObject).realmSet$unit(((ProductRealmProxyInterface) newObject).realmGet$unit());
        ((ProductRealmProxyInterface) realmObject).realmSet$quantum(((ProductRealmProxyInterface) newObject).realmGet$quantum());
        ((ProductRealmProxyInterface) realmObject).realmSet$price(((ProductRealmProxyInterface) newObject).realmGet$price());
        ((ProductRealmProxyInterface) realmObject).realmSet$total(((ProductRealmProxyInterface) newObject).realmGet$total());
        ((ProductRealmProxyInterface) realmObject).realmSet$addedToCart(((ProductRealmProxyInterface) newObject).realmGet$addedToCart());
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
        ProductRealmProxy aProduct = (ProductRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aProduct.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aProduct.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aProduct.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
