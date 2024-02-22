package com.cellodove.migrating_compose.sunflower.plantdetail


import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import com.cellodove.migrating_compose.R
import com.cellodove.migrating_compose.sunflower.data.Plant
import com.cellodove.migrating_compose.sunflower.viewmodels.PlantDetailViewModel

@Composable
fun PlantDetailDescription(plantDetailViewModel: PlantDetailViewModel) {
    val plant by plantDetailViewModel.plant.observeAsState()

    plant?.let {
        PlantDetailContent(plant = it)
    }
}










@Composable
fun PlantDetailContent(plant : Plant){
    Surface {
        Column(Modifier.padding(dimensionResource(id = R.dimen.margin_normal))) {
            PlantName(name = plant.name)
            PlantWatering(wateringInterval = plant.wateringInterval)
            PlantDescription(description = plant.description)
        }
    }

}
@Composable
private fun PlantName(name : String){
    Text(
        text = name,
        style = MaterialTheme.typography.headlineMedium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(id = R.dimen.margin_small))
            .wrapContentWidth(Alignment.CenterHorizontally)
    )
}


@Composable
private fun PlantWatering(wateringInterval : Int){
    Column(Modifier.fillMaxWidth()) {
        val centerWithPaddingModifier = Modifier
            .padding(horizontal = dimensionResource(id = R.dimen.margin_small))
            .align(Alignment.CenterHorizontally)

        val normalPadding = dimensionResource(id = R.dimen.margin_normal)


        Text(
            text = stringResource(id = R.string.watering_needs_prefix),
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            modifier = centerWithPaddingModifier.padding(top = normalPadding)
        )

        val wateringIntervalText = pluralStringResource(
            id = R.plurals.watering_needs_suffix,
            count = wateringInterval,
            wateringInterval
        )

        Text(
            text = wateringIntervalText,
            modifier = centerWithPaddingModifier.padding(top = normalPadding)
        )
    }
}

@Composable
private fun PlantDescription( description : String){
    val htmlDescription = remember(description){
        HtmlCompat.fromHtml(description , HtmlCompat.FROM_HTML_MODE_COMPACT)
    }

    AndroidView(
        factory = {context ->
            TextView(context).apply {
                movementMethod = LinkMovementMethod.getInstance()
            }
        },
        update = {
            it.text = htmlDescription
        }
    )
}




















@Preview
@Composable
private fun PlantDetailContentPreview(){
    val plant = Plant("id", "Apple", "HTML<br><br>description", 3, 30, "")
    MaterialTheme {
        PlantDetailContent(plant = plant)
    }
}


@Preview
@Composable
private fun PlantNamePreview(){
    MaterialTheme {
        PlantName(name = "Apple")
    }
}

@Preview
@Composable
private fun PlantWateringPreview(){
    MaterialTheme{
        PlantWatering(7)
    }
}

@Preview
@Composable
private fun PlantDescriptionPreview(){
    MaterialTheme{
        PlantDescription(description = "HTML<br><br>description")
    }
}


