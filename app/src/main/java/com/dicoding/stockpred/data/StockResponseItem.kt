import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "stock_response_item")
data class StockResponseItem(

    @PrimaryKey
    @SerializedName("code") val code: String,

    @SerializedName("website") val website: String,

    @SerializedName("name") val name: String,

    @SerializedName("logo") val logo: String,

    @SerializedName("description") val description: String,

    @SerializedName("sector") val sector: String
)
