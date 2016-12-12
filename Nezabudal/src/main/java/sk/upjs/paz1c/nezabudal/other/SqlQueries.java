package sk.upjs.paz1c.nezabudal.other;

/**
 *
 * @author Mikey
 */
public class SqlQueries {

    public static final String GET_ITEMS_BY_CATEGORY = "SELECT i.id as item_id,\n"
            + "	   i.name as item_name,\n"
            + "	   i.description as item_description, \n"
            + "       i.is_borrowed as item_is_borrowed, \n"
            + "       c.id as category_id, c.title as category_title \n"
            + "       from \n"
            + "       item as i join category as c\n"
            + "       on i.category_id = c.id\n"
            + "       where category_id = ?;";

    public static final String GET_ALL_ITEMS = "SELECT \n"
            + "	attr_values.id as attribute_value_id, \n"
            + "    attr_names.id as attribute_name_id,\n"
            + "    attr_names.name as attribute_name, \n"
            + "    attr_values.value as attribute_value \n"
            + "		from attribute_values as attr_values \n"
            + "			join attribute_names as attr_names \n"
            + "			on attr_names.id = attr_values.attribute_name_id\n"
            + "            where attr_values.item_id = ?;";

    public static final String GET_ITEM_BY_ID = "SELECT i.id as item_id,\n"
            + "	   i.name as item_name,\n"
            + "	   i.description as item_description, \n"
            + "       i.is_borrowed as item_is_borrowed, \n"
            + "       c.id as category_id, c.title as category_title \n"
            + "       from \n"
            + "       item as i join category as c\n"
            + "       on i.category_id = c.id"
            + "       where i.id = ?;";

    public static final String GET_ATTRIBUTE_BY_NAME_ID = "SELECT \n"
            + "	attr_values.id as attribute_value_id, \n"
            + "    attr_names.id as attribute_name_id,\n"
            + "    attr_names.name as attribute_name, \n"
            + "    attr_values.value as attribute_value \n"
            + "		from attribute_values as attr_values \n"
            + "			join attribute_names as attr_names \n"
            + "			on attr_names.id = attr_values.attribute_name_id\n"
            + "            where attr_names.id = ?;";

    public static final String GET_ATTRIBUTE_BY_NAME_ID_AND_ITEM = "SELECT \n"
            + "	attr_values.id as attribute_value_id, \n"
            + "    attr_names.id as attribute_name_id,\n"
            + "    attr_names.name as attribute_name, \n"
            + "    attr_values.value as attribute_value \n"
            + "		from attribute_values as attr_values \n"
            + "			join attribute_names as attr_names \n"
            + "			on attr_names.id = attr_values.attribute_name_id\n"
            + "            where attr_names.id = ? and attr_values.item_id = ?;";
    
    public static final String GET_ATTRIBUTES_BY_ITEM = "SELECT \n"
            + "    attr_values.id as attribute_value_id, \n"
            + "    attr_names.id as attribute_name_id,"
            + "    attr_names.name as attribute_name, \n"
            + "    attr_values.value as attribute_value \n"
            + "		from attribute_values as attr_values \n"
            + "			join attribute_names as attr_names \n"
            + "			on attr_names.id = attr_values.attribute_name_id\n"
            + "            where attr_values.item_id = ?;";

    public static final String GET_ATTRIBUTES_BY_CATEGORY = "SELECT \n"
            + "null as attribute_value_id,\n"
            + "    null as attribute_value,\n"
            + "    id as attribute_name_id,\n"
            + "    name as attribute_name \n"
            + "		from attribute_names\n"
            + "            where category_id = ?;";
    
    public static final String GET_BORROWED_ITEMS = "SELECT i.id as item_id,\n"
            + "	   i.name as item_name,\n"
            + "	   i.description as item_description, \n"
            + "       i.is_borrowed as item_is_borrowed, \n"
            + "       c.id as category_id, c.title as category_title \n"
            + "		from \n"
            + "       item as i join category as c\n"
            + "       on i.category_id = c.id\n"
            + "       where is_borrowed = 0;";

}
