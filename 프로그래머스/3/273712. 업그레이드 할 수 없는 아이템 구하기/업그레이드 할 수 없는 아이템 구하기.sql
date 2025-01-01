SELECT 
    i.ITEM_ID, 
    i.ITEM_NAME, 
    i.RARITY
FROM 
    ITEM_INFO i
WHERE 
    i.ITEM_ID NOT IN (
        SELECT
            t.PARENT_ITEM_ID
        FROM
            ITEM_TREE t
        WHERE
            t.PARENT_ITEM_ID IS NOT NULL
    )
ORDER BY
    i.ITEM_ID DESC;
